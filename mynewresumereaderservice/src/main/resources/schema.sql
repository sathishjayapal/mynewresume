DROP TABLE security_user IF EXISTS;
DROP TABLE resume_user_profile IF EXISTS;

CREATE TABLE security_user
(
    id        INTEGER IDENTITY PRIMARY KEY,
    user_name VARCHAR(30),
    password  VARCHAR(30),
    active    BOOLEAN,
    roles     VARCHAR(20)
);
CREATE INDEX security_user_user_name ON security_user (user_name);

CREATE TABLE resume_user_profile
(
    id             INTEGER IDENTITY PRIMARY KEY,
    user_name      VARCHAR(30),
    theme          VARCHAR(30),
    summary        VARCHAR(80),
    name           VARCHAR(80),
    phone          VARCHAR(12),
    twitter_handle VARCHAR(60),
    git_hub_repo   VARCHAR(90)
);
CREATE INDEX resume_user_profile_user_name ON resume_user_profile (user_name);

ALTER TABLE resume_user_profile
    ADD CONSTRAINT fk_resume_user_profile_security FOREIGN KEY (user_name) REFERENCES security_user (user_name);
