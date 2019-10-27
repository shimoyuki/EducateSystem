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

ALTER TABLE `scse`.`studentquality` 
CHANGE COLUMN `GoodClass` `GoodClass` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `FulltimeMoral` `FulltimeMoral` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `MoralTask` `MoralTask` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `MoralNum` `MoralNum` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `MoralText` `MoralText` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `ProvGoodGrade` `ProvGoodGrade` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `ProvGoodCadre` `ProvGoodCadre` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `ProvGoodStud` `ProvGoodStud` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `CrimeRate` `CrimeRate` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `CampusViolence` `CampusViolence` FLOAT NOT NULL ,
CHANGE COLUMN `ExamDiscip` `ExamDiscip` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `JoinOrgan` `JoinOrgan` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `JoinPraty` `JoinPraty` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `SocailVolun` `SocailVolun` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `StudentOrgan` `StudentOrgan` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `OrganStu` `OrganStu` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `StateCivil` `StateCivil` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `ProvinCivil` `ProvinCivil` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `CityCivil` `CityCivil` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `StateFirstAward` `StateFirstAward` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `StateSecondAward` `StateSecondAward` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `StateThirdAward` `StateThirdAward` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `ProvinFirstAward` `ProvinFirstAward` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `ProvinSecondAward` `ProvinSecondAward` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `ProvinThirdAward` `ProvinThirdAward` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `CityFirstAward` `CityFirstAward` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `CitySecondAward` `CitySecondAward` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `CityThirdAward` `CityThirdAward` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `CareerCert` `CareerCert` FLOAT NOT NULL DEFAULT '0' ;

ALTER TABLE `scse`.`employquality` 
CHANGE COLUMN `Soldier` `Soldier` FLOAT NULL DEFAULT '0' ;

ALTER TABLE `scse`.`skilltrain` 
CHANGE COLUMN `LocalFoster` `LocalFoster` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `LocalTrain` `LocalTrain` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `TrackProblemNum` `TrackProblemNum` FLOAT NOT NULL ;

ALTER TABLE `scse`.`socialservice` 
CHANGE COLUMN `TrainStaff` `TrainStaff` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `TrainUnabled` `TrainUnabled` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `TrainUnemStaff` `TrainUnemStaff` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `TrainFarmer` `TrainFarmer` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `TrainRetireSoldier` `TrainRetireSoldier` FLOAT NOT NULL DEFAULT '0' ;

ALTER TABLE `scse`.`counpasupp` 
CHANGE COLUMN `HelpObject` `HelpObject` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `PoverReducTarget` `PoverReducTarget` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `ServiceNum` `ServiceNum` FLOAT NOT NULL DEFAULT '0' ;


