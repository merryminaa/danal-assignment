CREATE TABLE CommercialDistrict (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    bizNo VARCHAR(255) NOT NULL,
    bizName VARCHAR(255) NOT NULL,
    branchName VARCHAR(255),
    mainClassCode VARCHAR(255) NOT NULL,
    mainClassCodeName VARCHAR(255) NOT NULL,
    subClassCode VARCHAR(255) NOT NULL,
    subClassCodeName VARCHAR(255) NOT NULL,
    detailClassCode VARCHAR(255) NOT NULL,
    detailClassCodeName VARCHAR(255) NOT NULL,
    standardClassCode VARCHAR(255) NOT NULL,
    standardClassCodeName VARCHAR(255) NOT NULL,
    createdAt timestamp NOT NULL
);
