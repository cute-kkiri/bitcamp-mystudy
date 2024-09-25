package bitcamp.myapp.context;

import bitcamp.myapp.annotation.Bean;
import bitcamp.myapp.annotation.Controller;

import javax.servlet.ServletContext;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApplicationContext {

    private Map<Class<?>, Object> dependencyMap = new HashMap<>();
    private List<Object> controllers = new ArrayList<>();

    public ApplicationContext(ServletContext ctx, Class<?> configClass) throws Exception {
        try {
            dependencyMap.put(ServletContext.class, ctx);

            processBeanAnnotation(configClass);

            createControllers();

        } catch (Exception e) {
            System.out.println("객체 준비 중 오류 발생!");
            e.printStackTrace();
        }
    }

    private void processBeanAnnotation(Class<?> configClass) throws Exception {
        Constructor<?> constructor = configClass.getConstructors()[0];
        Object configObject = constructor.newInstance();
        dependencyMap.put(configClass, configObject);

        List<Method> factoryMethods = getFactoryMethods(configClass);

        int beforeSize = 0;
        do {
            beforeSize = factoryMethods.size();
            if (beforeSize == 0) {
                break;
            }

            factoryMethods = callFactoryMethods(configObject, factoryMethods);
        } while (beforeSize > factoryMethods.size());

        System.out.println("남아 있는 팩토리 메서드:");
        for (Method m : factoryMethods) {
            System.out.println("  - " + m.getName());
        }
    }

    private List<Method> callFactoryMethods(Object obj, List<Method> factoryMethods) {
        ArrayList<Method> waitingFactoryMethods = new ArrayList<>();
        for (Method factoryMethod : factoryMethods) {
            try {
                Class<?>[] paramTypes = factoryMethod.getParameterTypes();
                Object[] args = prepareMethodArguments(paramTypes);
                dependencyMap.put(factoryMethod.getReturnType(), factoryMethod.invoke(obj, args));
            } catch (Exception e) {
                // 메서드를 호출할 때 넘겨줄 아규먼트의 값 중 한 개라도 없다면 대기열에 추가
                waitingFactoryMethods.add(factoryMethod);
            }
        }
        return waitingFactoryMethods;
    }

    private List<Method> getFactoryMethods(Class<?> type) {
        Method[] methods = type.getDeclaredMethods();
        ArrayList<Method> list = new ArrayList<>();

        for (Method m : methods) {
            Bean beanAnno = m.getAnnotation(Bean.class);
            if (beanAnno == null) {
                continue;
            }
            list.add(m);
        }
        return list;
    }

    private void createControllers() throws Exception {
        // 컴파일된 클래스 파일이 놓이는 폴더에서 클래스 파일을 찾는다.
        File dir = new File("build/classes/java/main");

        searchClasses(dir, "");
    }

    public Object getBean(Class<?> type) {
        return dependencyMap.get(type);
    }

    public List<Object> getControllers() {
        return controllers;
    }


    private void searchClasses(File dir, String packageName) throws Exception {
        File[] files = dir.listFiles();

        if (packageName.length() > 0) {
            packageName += ".";
        }

        for (File file : files) {
            if (file.isDirectory()) {
                searchClasses(file, packageName + file.getName());
            } else {
                if (file.getName().contains("$")) {
                    continue;
                }
                String className = packageName + file.getName().replace(".class", "");

                Class<?> clazz = Class.forName(className);
                Controller controllerAnno = clazz.getAnnotation(Controller.class);
                if (controllerAnno == null) {
                    continue;
                }

                createObject(clazz);
            }
        }
    }

    private void createObject(Class<?> clazz) throws Exception {
        Constructor<?> constructor = clazz.getConstructors()[0];

        Class<?>[] paramTypes = constructor.getParameterTypes();
        Object[] args = prepareMethodArguments(paramTypes);

        controllers.add(constructor.newInstance(args));
    }

    private Object[] prepareMethodArguments(Class<?>[] paramTypes) throws Exception {
        Object[] args = new Object[paramTypes.length];
        for (int i = 0; i < paramTypes.length; i++) {
            Object arg = dependencyMap.get(paramTypes[i]);
            if (arg == null) {
                throw new Exception("해당 타입의 값을 찾을 수 없습니다.");
            }
            args[i] = arg;
        }
        return args;
    }


}
