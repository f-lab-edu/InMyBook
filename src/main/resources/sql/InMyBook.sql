﻿CREATE TABLE `POST`
(
    `ID`                 BIGINT UNSIGNED	NOT NULL PRIMARY KEY,
    `POST_UUID`          VARCHAR(36)   NOT NULL,
    `TITLE`              VARCHAR(150)  NOT NULL,
    `CONTENT`            TEXT NULL,
    `READING_STATE`      VARCHAR(5) NULL,
    `READING_START_DATE` DATETIME NULL,
    `READING_END_DATE`   DATETIME NULL,
    `RATING`             DECIMAL(2, 1) NOT NULL DEFAULT 0.0,
    `PUBLIC_YN`          VARCHAR(1)    NOT NULL DEFAULT N,
    `REGIST_DATE`        DATETIME               DEFAULT CURRENT_TIMESTAMP NOT NULL,
    `UPDATE_DATE`        DATETIME               DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NULL,
    `MEMBER_ID`          BIGINT UNSIGNED	NOT NULL,
    `BOOK_ID`            BIGINT UNSIGNED	NOT NULL,
    CONSTRAINT UQ_POST_UUID UNIQUE (POST_UUID)
);

CREATE TABLE `MEMBER`
(
    `ID`          BIGINT UNSIGNED	NOT NULL PRIMARY KEY,
    `MEMBER_UUID` VARCHAR(36)  NOT NULL,
    `EMAIL`       VARCHAR(255) NOT NULL,
    `PASSWORD`    CHAR(60)     NOT NULL,
    `NICKNAME`    VARCHAR(30)  NOT NULL,
    `USE_YN`      VARCHAR(1)   NOT NULL,
    CONSTRAINT UQ_MEMBER_UUID UNIQUE (MEMBER_UUID),
    CONSTRAINT UQ_EMAIL UNIQUE (EMAIL),
    CONSTRAINT UQ_NICKNAME UNIQUE (NICKNAME)
);

CREATE TABLE `ATTACH`
(
    `ID`            BIGINT UNSIGNED	NOT NULL PRIMARY KEY,
    `FILE_NAME`     VARCHAR(36) NULL,
    `ORG_FILE_NAME` VARCHAR(255) NULL,
    `FILE_EXT`      VARCHAR(4) NULL,
    `FILE_DATA`     BLOB NULL,
    `FILE_SIZE`     INT UNSIGNED NULL,
    `BOOK_ID`       BIGINT UNSIGNED NOT NULL
);

CREATE TABLE `COMMENT`
(
    `ID`                BIGINT UNSIGNED NOT NULL PRIMARY KEY,
    `COMMENT_CONTENT`   VARCHAR(800)                       NOT NULL,
    `REGIST_DATE`       DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
    `UPDATE_DATE`       DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NULL,
    `DEPTH`             INT UNSIGNED NOT NULL,
    `PARENT_COMMENT_ID` BIGINT UNSIGNED NULL,
    `POST_ID`           BIGINT UNSIGNED NOT NULL,
    `COMMENTER_ID`      BIGINT UNSIGNED	NOT NULL,
);

CREATE TABLE `BOOK`
(
    `ID`             BIGINT UNSIGNED NOT NULL PRIMARY KEY,
    `ISBN_NO`        VARCHAR(24) NULL,
    `BOOK_NAME`      VARCHAR(1200) NOT NULL,
    `BOOK_DETAILS`   TEXT NULL,
    `AUTHOR`         VARCHAR(1000) NULL,
    `PUBLISHER`      VARCHAR(1000) NULL,
    `BOOK_THUMB_URL` VARCHAR(1000) NULL
);

CREATE TABLE `LIKE`
(
    `ID`        BIGINT UNSIGNED	NOT NULL PRIMARY KEY,
    `BOOK_ID`   BIGINT UNSIGNED	NOT NULL,
    `MEMBER_ID` BIGINT UNSIGNED	NOT NULL,
);

CREATE TABLE `BOOKMARK`
(
    `ID`        BIGINT UNSIGNED	NOT NULL PRIMARY KEY,
    `BOOK_ID`   BIGINT UNSIGNED	NOT NULL,
    `MEMBER_ID` BIGINT UNSIGNED	NOT NULL,
);


ALTER TABLE `POST`
    ADD CONSTRAINT `FK_MEMBER_TO_POST_1` FOREIGN KEY (
                                                      `MEMBER_ID`
        )
        REFERENCES `MEMBER` (
                             `ID`
            );

ALTER TABLE `POST`
    ADD CONSTRAINT `FK_BOOK_TO_POST_1` FOREIGN KEY (
                                                    `BOOK_ID`
        )
        REFERENCES `BOOK` (
                           `ID`
            );

ALTER TABLE `ATTACH`
    ADD CONSTRAINT `FK_BOOK_TO_ATTACH_1` FOREIGN KEY (
                                                      `BOOK_ID`
        )
        REFERENCES `BOOK` (
                           `ID`
            );

ALTER TABLE `COMMENT`
    ADD CONSTRAINT `FK_COMMENT_TO_COMMENT_1` FOREIGN KEY (
                                                          `PARENT_COMMENT_ID`
        )
        REFERENCES `COMMENT` (
                              `ID`
            );

ALTER TABLE `COMMENT`
    ADD CONSTRAINT `FK_POST_TO_COMMENT_1` FOREIGN KEY (
                                                       `POST_ID`
        )
        REFERENCES `POST` (
                           `ID`
            );

ALTER TABLE `COMMENT`
    ADD CONSTRAINT `FK_MEMBER_TO_COMMENT_1` FOREIGN KEY (
                                                         `COMMENTER_ID`
        )
        REFERENCES `MEMBER` (
                             `ID`
            );

ALTER TABLE `LIKE`
    ADD CONSTRAINT `FK_POST_TO_LIKE_1` FOREIGN KEY (
                                                    `BOOK_ID`
        )
        REFERENCES `POST` (
                           `ID`
            );

ALTER TABLE `LIKE`
    ADD CONSTRAINT `FK_MEMBER_TO_LIKE_1` FOREIGN KEY (
                                                      `MEMBER_ID`
        )
        REFERENCES `MEMBER` (
                             `ID`
            );

ALTER TABLE `BOOKMARK`
    ADD CONSTRAINT `FK_POST_TO_BOOKMARK_1` FOREIGN KEY (
                                                        `POST_ID`
        )
        REFERENCES `POST` (
                           `ID`
            );

ALTER TABLE `BOOKMARK`
    ADD CONSTRAINT `FK_MEMBER_TO_BOOKMARK_1` FOREIGN KEY (
                                                          `MEMBER_ID`
        )
        REFERENCES `MEMBER` (
                             `ID`
            );