# 📚 명언 저장 앱 📚

[🔗 application 디렉토리 바로가기](https://github.com/choideakook/project_analects/tree/main/src/main/java/org/example/application)

## ✏️ 명령어 가이드

- 등록 : 새로운 명언 등록
- 목록 : 등록된 모든 명언 조회
- 삭제 : 지정된 명언을 삭제
  - ?id= : 지정된 id 의 명언을 삭제
  - ?작가= : 지정된 작가의 명언을 삭제
- 수정 : 지정된 명언을 수정
  - ?id= : 지정된 id 의 명언을 삭제
  - ?작가= : 지정된 작가의 명언을 삭제
- 종료 : application 종료

## ✏️ Project 요구사항

- 작가와 명언을 저장 기능
    - 저장된 객체를 고유번호로 관리
- 저장된 객체 수정 기능
- 저장된 객체 삭제 기능
- 저장된 모든 객체를 조회 기능
- 잘못된 명령어를 안내하는 기능
- 파일을 통해 저장된 객체 영속화
- 저장된 객체를 JSON 으로 빌드

<br>

## ✏️ application  아키텍처

```java
Controller --> Service --> Repository
       ^         ^           ^
        \        |          /
         \---  Domain ----/
```

- ***계층형 구조 사용***
    - Controller : client 의 명령을 기준으로 알맞는 service 를 실행시킴
    - Service : Repository 를 통해 실질적인 business 로직을 수행
    - Repository : Service 가 요청한 CRUD 수행
    - Domain : 필드가 모여있는 계층, 모든 계층에서 사용된다.
