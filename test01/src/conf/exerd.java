-- 프로젝트
DROP TABLE IF EXISTS PJT RESTRICT;

-- 학생
DROP TABLE IF EXISTS STU RESTRICT;

-- 게시판
DROP TABLE IF EXISTS BOD RESTRICT;

-- 매니저
DROP TABLE IF EXISTS MNG RESTRICT;

-- 강사
DROP TABLE IF EXISTS TEA RESTRICT;

-- 교육과정
DROP TABLE IF EXISTS EDU RESTRICT;

-- 인적정보
DROP TABLE IF EXISTS ID RESTRICT;

-- 팀멤버
DROP TABLE IF EXISTS PJTT RESTRICT;

-- 프로젝트
CREATE TABLE PJT (
  PNO   INTEGER      NOT NULL COMMENT '프로젝트번호', -- 프로젝트번호
  INOL  INTEGER      NULL     COMMENT '팀장', -- 팀장
  INOT  INTEGER      NULL     COMMENT '강사번호', -- 강사번호
  TITL  VARCHAR(100) NOT NULL COMMENT '프로젝트명', -- 프로젝트명
  ST_DT DATE         NULL     COMMENT '시작일', -- 시작일
  EN_DT DATE         NULL     COMMENT '종료일', -- 종료일
  DES   VARCHAR(255) NULL     COMMENT '설명', -- 설명
  STATE INTEGER(101) NULL     COMMENT '상태', -- 상태
  NUMB  INTEGER      NOT NULL COMMENT '참가인원', -- 참가인원
  SLOG  VARCHAR(255) NULL     COMMENT '팀구호', -- 팀구호
  CR_DT DATE         NULL     COMMENT '팀 창립일', -- 팀 창립일
  ENO   INTEGER      NULL     COMMENT '교육과정번호' -- 교육과정번호
)
COMMENT '프로젝트';

-- 프로젝트
ALTER TABLE PJT
  ADD CONSTRAINT PK_PJT -- 프로젝트 기본키
    PRIMARY KEY (
      PNO -- 프로젝트번호
    );

ALTER TABLE PJT
  MODIFY COLUMN PNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '프로젝트번호';

-- 학생
CREATE TABLE STU (
  INO INTEGER NOT NULL COMMENT '학생번호' -- 학생번호
)
COMMENT '학생';

-- 학생
ALTER TABLE STU
  ADD CONSTRAINT PK_STU -- 학생 기본키
    PRIMARY KEY (
      INO -- 학생번호
    );

-- 게시판
CREATE TABLE BOD (
  BNO   INTEGER      NOT NULL COMMENT '게시물번호', -- 게시물번호
  TITL  VARCHAR(100) NOT NULL COMMENT '제목', -- 제목
  CONT  VARCHAR(255) NULL     COMMENT '내용', -- 내용
  VIEWS INTEGER      NULL     COMMENT '조회수', -- 조회수
  PASS  VARCHAR(100) NOT NULL COMMENT '암호', -- 암호
  CR_DT DATE         NOT NULL COMMENT '작성일', -- 작성일
  AUTH  VARCHAR(50)  NOT NULL COMMENT '작성자', -- 작성자
  INO   INTEGER      NULL     COMMENT '학생번호' -- 학생번호
)
COMMENT '게시판';

-- 게시판
ALTER TABLE BOD
  ADD CONSTRAINT PK_BOD -- 게시판 기본키
    PRIMARY KEY (
      BNO -- 게시물번호
    );

-- 게시판 인덱스
CREATE INDEX IX_BOD
  ON BOD( -- 게시판
    CR_DT ASC -- 작성일
  );

ALTER TABLE BOD
  MODIFY COLUMN BNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '게시물번호';

-- 매니저
CREATE TABLE MNG (
  INO INTEGER NOT NULL COMMENT '매니저번호' -- 매니저번호
)
COMMENT '매니저';

-- 매니저
ALTER TABLE MNG
  ADD CONSTRAINT PK_MNG -- 매니저 기본키
    PRIMARY KEY (
      INO -- 매니저번호
    );

-- 강사
CREATE TABLE TEA (
  INO INTEGER NOT NULL COMMENT '강사번호' -- 강사번호
)
COMMENT '강사';

-- 강사
ALTER TABLE TEA
  ADD CONSTRAINT PK_TEA -- 강사 기본키
    PRIMARY KEY (
      INO -- 강사번호
    );

-- 교육과정
CREATE TABLE EDU (
  ENO  INTEGER      NOT NULL COMMENT '교육과정번호', -- 교육과정번호
  TITL VARCHAR(100) NOT NULL COMMENT '과정명', -- 과정명
  ROOM VARCHAR(100) NOT NULL COMMENT '강의실', -- 강의실
  INO  INTEGER      NULL     COMMENT '매니저번호' -- 매니저번호
)
COMMENT '교육과정';

-- 교육과정
ALTER TABLE EDU
  ADD CONSTRAINT PK_EDU -- 교육과정 기본키
    PRIMARY KEY (
      ENO -- 교육과정번호
    );

-- 교육과정 인덱스
CREATE INDEX IX_EDU
  ON EDU( -- 교육과정
    ENO ASC -- 교육과정번호
  );

ALTER TABLE EDU
  MODIFY COLUMN ENO INTEGER NOT NULL AUTO_INCREMENT COMMENT '교육과정번호';

-- 인적정보
CREATE TABLE ID (
  INO   INTEGER      NOT NULL COMMENT '인적정보번호', -- 인적정보번호
  INM   VARCHAR(50)  NOT NULL COMMENT '이름', -- 이름
  AGE   INTEGER      NULL     COMMENT '나이', -- 나이
  GEND  VARCHAR(100) NULL     COMMENT '성별', -- 성별
  TEL   VARCHAR(30)  NOT NULL COMMENT '전화', -- 전화
  STEP  VARCHAR(100) NULL     COMMENT '학력', -- 학력
  PASS  VARCHAR(100) NOT NULL COMMENT '암호', -- 암호
  EMAIL VARCHAR(100) NOT NULL COMMENT '이메일' -- 이메일
)
COMMENT '인적정보';

-- 인적정보
ALTER TABLE ID
  ADD CONSTRAINT PK_ID -- 인적정보 기본키
    PRIMARY KEY (
      INO -- 인적정보번호
    );

-- 인적정보 인덱스
CREATE INDEX IX_ID
  ON ID( -- 인적정보
    INM ASC -- 이름
  );

ALTER TABLE ID
  MODIFY COLUMN INO INTEGER NOT NULL AUTO_INCREMENT COMMENT '인적정보번호';

-- 팀멤버
CREATE TABLE PJTT (
  PNO INTEGER NOT NULL COMMENT '프로젝트번호', -- 프로젝트번호
  INO INTEGER NOT NULL COMMENT '학생번호' -- 학생번호
)
COMMENT '팀멤버';

-- 팀멤버
ALTER TABLE PJTT
  ADD CONSTRAINT PK_PJTT -- 팀멤버 기본키
    PRIMARY KEY (
      PNO, -- 프로젝트번호
      INO  -- 학생번호
    );

-- 프로젝트
ALTER TABLE PJT
  ADD CONSTRAINT FK_EDU_TO_PJT -- 교육과정 -> 프로젝트
    FOREIGN KEY (
      ENO -- 교육과정번호
    )
    REFERENCES EDU ( -- 교육과정
      ENO -- 교육과정번호
    );

-- 프로젝트
ALTER TABLE PJT
  ADD CONSTRAINT FK_TEA_TO_PJT -- 강사 -> 프로젝트
    FOREIGN KEY (
      INOT -- 강사번호
    )
    REFERENCES TEA ( -- 강사
      INO -- 강사번호
    );

-- 프로젝트
ALTER TABLE PJT
  ADD CONSTRAINT FK_STU_TO_PJT -- 학생 -> 프로젝트
    FOREIGN KEY (
      INOL -- 팀장
    )
    REFERENCES STU ( -- 학생
      INO -- 학생번호
    );

-- 학생
ALTER TABLE STU
  ADD CONSTRAINT FK_ID_TO_STU -- 인적정보 -> 학생
    FOREIGN KEY (
      INO -- 학생번호
    )
    REFERENCES ID ( -- 인적정보
      INO -- 인적정보번호
    );

-- 게시판
ALTER TABLE BOD
  ADD CONSTRAINT FK_STU_TO_BOD -- 학생 -> 게시판
    FOREIGN KEY (
      INO -- 학생번호
    )
    REFERENCES STU ( -- 학생
      INO -- 학생번호
    );

-- 매니저
ALTER TABLE MNG
  ADD CONSTRAINT FK_ID_TO_MNG -- 인적정보 -> 매니저
    FOREIGN KEY (
      INO -- 매니저번호
    )
    REFERENCES ID ( -- 인적정보
      INO -- 인적정보번호
    );

-- 강사
ALTER TABLE TEA
  ADD CONSTRAINT FK_ID_TO_TEA -- 인적정보 -> 강사
    FOREIGN KEY (
      INO -- 강사번호
    )
    REFERENCES ID ( -- 인적정보
      INO -- 인적정보번호
    );

-- 교육과정
ALTER TABLE EDU
  ADD CONSTRAINT FK_MNG_TO_EDU -- 매니저 -> 교육과정
    FOREIGN KEY (
      INO -- 매니저번호
    )
    REFERENCES MNG ( -- 매니저
      INO -- 매니저번호
    );

-- 팀멤버
ALTER TABLE PJTT
  ADD CONSTRAINT FK_PJT_TO_PJTT -- 프로젝트 -> 팀멤버
    FOREIGN KEY (
      PNO -- 프로젝트번호
    )
    REFERENCES PJT ( -- 프로젝트
      PNO -- 프로젝트번호
    );

-- 팀멤버
ALTER TABLE PJTT
  ADD CONSTRAINT FK_STU_TO_PJTT -- 학생 -> 팀멤버
    FOREIGN KEY (
      INO -- 학생번호
    )
    REFERENCES STU ( -- 학생
      INO -- 학생번호
    );
    
insert into ID (INM, AGE, GEND, TEL, STEP, PASS, EMAIL)
values('곽용호',30,'남자','111-1111','대졸','1111','kwak@test.com');

insert into EDU (TITL,ROOM)
values('자바&DB 80기','401호');

insert into PJT(TITL,ST_DT,EN_DT,DES,STATE,NUMB,SLOG,CR_DT)
values('lollol','2016-04-21','2016-06-21','롤을 하자', 80,5,'스웨인 장인','2016-04-21');


insert into BOD(TITL,CONT,VIEWS,PASS,CR_DT,AUTH)
values('밍견 강등됨','ㅠㅠㅠ 슬픔',400,'1111',curDate(),'김운남');