package bitcamp.myapp.service;

import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.vo.AttachedFile;
import bitcamp.myapp.vo.Board;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DefaultBoardService implements BoardService {

  private BoardDao boardDao;
  private PlatformTransactionManager txManager;

  public DefaultBoardService(BoardDao boardDao, PlatformTransactionManager txManager) {
    this.boardDao = boardDao;
    this.txManager = txManager;
  }

  @Transactional
  public void add(Board board) throws Exception {
    boardDao.insert(board);
    if (board.getAttachedFiles().size() > 0) {
      boardDao.insertFiles(board);
    }
  }

  public List<Board> list() throws Exception {
    return boardDao.list();
  }

  public Board get(int boardNo) throws Exception {
    return boardDao.findBy(boardNo);
  }

  @Transactional
  public void increaseViewCount(int boardNo) throws Exception {
    Board board = boardDao.findBy(boardNo);
    if (board != null) {
      boardDao.updateViewCount(board.getNo(), board.getViewCount() + 1);
    }
  }

  @Transactional
  public boolean update(Board board) throws Exception {
    if (!boardDao.update(board)) {
      return false;
    }

    if (board.getAttachedFiles().size() > 0) {
      boardDao.insertFiles(board);
    }
    return true;
  }

  @Transactional
  public void delete(int boardNo) throws Exception {
    boardDao.deleteFiles(boardNo);
    boardDao.delete(boardNo);
  }

  public AttachedFile getAttachedFile(int fileNo) throws Exception {
    return boardDao.getFile(fileNo);
  }

  @Transactional
  public boolean deleteAttachedFile(int fileNo) throws Exception {
    if (!boardDao.deleteFile(fileNo)) {
      return false;
    }
    return true;
  }
}
