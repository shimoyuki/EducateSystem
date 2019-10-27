ALTER TABLE `scse`.`schoolenterprise` 
CHANGE COLUMN `MajorNum` `MajorNum` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `CoopAgreeEnterp` `CoopAgreeEnterp` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `CoopAgreeMajor` `CoopAgreeMajor` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `CoopEnterpJoinTeachMajor` `CoopEnterpJoinTeachMajor` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `CoopEnterpJoinTeachTeacher` `CoopEnterpJoinTeachTeacher` FLOAT NOT NULL ,
CHANGE COLUMN `CoopEnterpJoinTeachClass` `CoopEnterpJoinTeachClass` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `EnterpBuildReseaDevelop` `EnterpBuildReseaDevelop` FLOAT NOT NULL ,
CHANGE COLUMN `OffSchoTeacherTrainBase` `OffSchoTeacherTrainBase` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `SchoEnterpCoopOrderClassNum` `SchoEnterpCoopOrderClassNum` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `SchoEnterpDevelopCourse` `SchoEnterpDevelopCourse` FLOAT NOT NULL DEFAULT '0' ;

ALTER TABLE `scse`.`groupschool` 
CHANGE COLUMN `LeadVocEduGroup` `LeadVocEduGroup` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `JoinLeadVocEduGroupScho` `JoinLeadVocEduGroupScho` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `JoinLeadVocEduGroupMajor` `JoinLeadVocEduGroupMajor` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `JoinVocEduGroup` `JoinVocEduGroup` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `JoinLeadVocEduGroupEnterp` `JoinLeadVocEduGroupEnterp` FLOAT NOT NULL DEFAULT '0' ;

ALTER TABLE `scse`.`teachers` 
CHANGE COLUMN `StaffNum` `StaffNum` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `StaffAdmin` `StaffAdmin` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `StaffPrepJob` `StaffPrepJob` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `FullTime` `FullTime` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `BasicCourse` `BasicCourse` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `Course` `Course` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `IndustryEnterprise` `IndustryEnterprise` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `UndergraLess` `UndergraLess` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `Undergra` `Undergra` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `FullPostgrad` `FullPostgrad` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `SubHighMore` `SubHighMore` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `IntermediateGrade` `IntermediateGrade` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `JuniorTitle` `JuniorTitle` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `NoConferTeac` `NoConferTeac` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `ThreeFiveLess` `ThreeFiveLess` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `ThreeSixFourFive` `ThreeSixFourFive` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `FourSixFiveFive` `FourSixFiveFive` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `FiveSixMore` `FiveSixMore` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `Male` `Male` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `Female` `Female` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `DoubleTeac` `DoubleTeac` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `InduEnterHour` `InduEnterHour` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `CounselCertificate` `CounselCertificate` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `FulltimeCounsel` `FulltimeCounsel` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `CityDiscipLeader` `CityDiscipLeader` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `ProvSuper` `ProvSuper` FLOAT NOT NULL DEFAULT '0' ;


