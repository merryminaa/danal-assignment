# danal-assignment

## 요구사항
1. 배치어플리케이션으로 CSV 파일들을 읽습니다. 항목에는 "상가업소번호","상호명","지점명" 등이 있습니다.
2. 배치어플리케이션으로 데이타베이스 MySQL 에 CSV의 데이타를 열을 구분하여 저장합니다.
3. 배치작업의 진행상황과 발생한 오류를 추적할수 있도록 로깅합니다.
4. 배치처리 로직의 기능을 검증하기 위해 단위테스트를 작성합니다.

## 작업내용
1. DB 연결정보 
- application.yml 에 기재된 정보로 연결 부탁드립니다. 
  -     url: jdbc:mysql://localhost:3306/danal, username: root, password: 1234

2. 데이터베이스 테이블 생성 SQL
- 서버 구동시 schema.sql 스크립트가 실행됩니다.
- db 컬럼의 경우 csv 파일의 일부 정보만 수록할 수 있도록 우선 개발하였습니다.

3. 배치 작업
- 서버 구동시 세종시 csv 파일을 읽어서 일부 맵핑된 필드만 insert되도록 하였습니다.

    

