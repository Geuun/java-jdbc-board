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

## Feedback
<details>
<summary>11.02</summary>
<div>

- Exception 구문을 추가하였을 때 왜 객체를 null로 생성하는 것인지 (물론 intellij로 자동생성함ㅋㅋ...)
- Exception 구문에서 ResultSet, PreparedStatement, Connection가 Null이라면 RuntimeException을 뱉게 설계하는데 null을 가르킨다는게 어떤 의미인지
- 당연하게도 id를 지정 안했을 때 getter를 사용하지 못하는 문제 발생
  - 우선 id를 직접 넣어줘서 마저 개발하려다 selectAll 을 구현해보기로함!


</div>
</details>