# JDBC로 게시판 (CRUD) 구현하기

## 기능

- Create
    - 글을 쓸 수 있는 기능
    - 글 번호, 제목, 내용, 작성자  구현
- Read
    - 이미 써져있는 글의 목록과 내용을 가져올 수 있는 기능
    - 글 번호, 제목, 작성자, 내용을 가져오기
- Update
    - 이미 작성된 글을 수정할 수 있는 기능
    - 글 제목, 내용을 수정하기
- Delete
    - 작성된 글을 삭제할 수 있는 기능

## DB설계
| column | dataType |  |
| --- | --- | --- |
| no | VARCHAR(45) | PK,NN |
| title | VARCHAR(45) | NN |
| content | LONGTEXT | NN |
| author | VARCHAR(10) | NN |

![스크린샷 2022-10-27 오전 1 36 45](https://user-images.githubusercontent.com/89567475/198088257-8f34d0aa-1166-4673-9229-4e1a03aaf2f5.png)
