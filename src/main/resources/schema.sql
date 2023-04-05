USE [master]
GO
/****** Object:  Database [StudentsAndTeachers]    Script Date: 3/1/2023 1:43:33 PM ******/
CREATE DATABASE [StudentsAndTeachers]
    CONTAINMENT = NONE
    ON PRIMARY
    ( NAME = N'StudentsAndTeachers', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\StudentsAndTeachers.mdf' , SIZE = 8192 KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536 KB )
    LOG ON
    ( NAME = N'StudentsAndTeachers_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\StudentsAndTeachers_log.ldf' , SIZE = 8192 KB , MAXSIZE = 2048 GB , FILEGROWTH = 65536 KB )
WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [StudentsAndTeachers] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
    begin
        EXEC [StudentsAndTeachers].[dbo].[sp_fulltext_database] @action = 'enable'
    end
GO
ALTER DATABASE [StudentsAndTeachers] SET ANSI_NULL_DEFAULT OFF
GO
ALTER DATABASE [StudentsAndTeachers] SET ANSI_NULLS OFF
GO
ALTER DATABASE [StudentsAndTeachers] SET ANSI_PADDING OFF
GO
ALTER DATABASE [StudentsAndTeachers] SET ANSI_WARNINGS OFF
GO
ALTER DATABASE [StudentsAndTeachers] SET ARITHABORT OFF
GO
ALTER DATABASE [StudentsAndTeachers] SET AUTO_CLOSE OFF
GO
ALTER DATABASE [StudentsAndTeachers] SET AUTO_SHRINK OFF
GO
ALTER DATABASE [StudentsAndTeachers] SET AUTO_UPDATE_STATISTICS ON
GO
ALTER DATABASE [StudentsAndTeachers] SET CURSOR_CLOSE_ON_COMMIT OFF
GO
ALTER DATABASE [StudentsAndTeachers] SET CURSOR_DEFAULT GLOBAL
GO
ALTER DATABASE [StudentsAndTeachers] SET CONCAT_NULL_YIELDS_NULL OFF
GO
ALTER DATABASE [StudentsAndTeachers] SET NUMERIC_ROUNDABORT OFF
GO
ALTER DATABASE [StudentsAndTeachers] SET QUOTED_IDENTIFIER OFF
GO
ALTER DATABASE [StudentsAndTeachers] SET RECURSIVE_TRIGGERS OFF
GO
ALTER DATABASE [StudentsAndTeachers] SET DISABLE_BROKER
GO
ALTER DATABASE [StudentsAndTeachers] SET AUTO_UPDATE_STATISTICS_ASYNC OFF
GO
ALTER DATABASE [StudentsAndTeachers] SET DATE_CORRELATION_OPTIMIZATION OFF
GO
ALTER DATABASE [StudentsAndTeachers] SET TRUSTWORTHY OFF
GO
ALTER DATABASE [StudentsAndTeachers] SET ALLOW_SNAPSHOT_ISOLATION OFF
GO
ALTER DATABASE [StudentsAndTeachers] SET PARAMETERIZATION SIMPLE
GO
ALTER DATABASE [StudentsAndTeachers] SET READ_COMMITTED_SNAPSHOT OFF
GO
ALTER DATABASE [StudentsAndTeachers] SET HONOR_BROKER_PRIORITY OFF
GO
ALTER DATABASE [StudentsAndTeachers] SET RECOVERY SIMPLE
GO
ALTER DATABASE [StudentsAndTeachers] SET MULTI_USER
GO
ALTER DATABASE [StudentsAndTeachers] SET PAGE_VERIFY CHECKSUM
GO
ALTER DATABASE [StudentsAndTeachers] SET DB_CHAINING OFF
GO
ALTER DATABASE [StudentsAndTeachers] SET FILESTREAM ( NON_TRANSACTED_ACCESS = OFF )
GO
ALTER DATABASE [StudentsAndTeachers] SET TARGET_RECOVERY_TIME = 60 SECONDS
GO
ALTER DATABASE [StudentsAndTeachers] SET DELAYED_DURABILITY = DISABLED
GO
ALTER DATABASE [StudentsAndTeachers] SET ACCELERATED_DATABASE_RECOVERY = OFF
GO
ALTER DATABASE [StudentsAndTeachers] SET QUERY_STORE = OFF
GO
USE [StudentsAndTeachers]
GO
/****** Object:  User [IskamDiploma]    Script Date: 3/1/2023 1:43:33 PM ******/
CREATE USER [IskamDiploma] FOR LOGIN [diplomaIskam] WITH DEFAULT_SCHEMA =[db_owner]
GO
ALTER ROLE [db_owner] ADD MEMBER [IskamDiploma]
GO
ALTER ROLE [db_accessadmin] ADD MEMBER [IskamDiploma]
GO
ALTER ROLE [db_securityadmin] ADD MEMBER [IskamDiploma]
GO
ALTER ROLE [db_ddladmin] ADD MEMBER [IskamDiploma]
GO
ALTER ROLE [db_backupoperator] ADD MEMBER [IskamDiploma]
GO
ALTER ROLE [db_datareader] ADD MEMBER [IskamDiploma]
GO
ALTER ROLE [db_datawriter] ADD MEMBER [IskamDiploma]
GO
ALTER ROLE [db_denydatareader] ADD MEMBER [IskamDiploma]
GO
ALTER ROLE [db_denydatawriter] ADD MEMBER [IskamDiploma]
GO
/****** Object:  Table [dbo].[Addresses]    Script Date: 3/1/2023 1:43:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Addresses]
(
    [Id]              [varchar](36)   NOT NULL PRIMARY KEY,
    [City]            [nvarchar](100) NOT NULL,
    [HouseNumber]    [int]           NOT NULL CHECK ([house_number] > 0),
    [Street]          [nvarchar](100) NOT NULL,
    [AdditionalInfo] [nvarchar](100) NULL,
)
CREATE TABLE [dbo].[Schools]
(
    [Id]         [varchar](36)   NOT NULL PRIMARY KEY,
    [Name]       [nvarchar](255) NOT NULL,
    [AddressId] [varchar](36)   NOT NULL UNIQUE,
    FOREIGN KEY ([AddressId]) REFERENCES Addresses (Id)
)
CREATE TABLE [dbo].[Users]
(
    [Id]         [varchar](36)   NOT NULL PRIMARY KEY,
    [Username]   [varchar](150)  NOT NULL UNIQUE,
    [Password]   [varchar](500)  NOT NULL,
    [Email]      [varchar](255)  NOT NULL UNIQUE,
    [FirstName] [nvarchar](100) NOT NULL,
    [LastName]  [nvarchar](100) NOT NULL,
    [SchoolId]  [varchar](36)   NOT NULL,
    Salt         varbinary(16)   NOT NULL,
    FOREIGN KEY ([SchoolId]) REFERENCES Schools (Id)
)

CREATE TABLE [dbo].[Admins]
(
    [Id]      [varchar](36) NOT NULL PRIMARY KEY,
    [UserId] [varchar](36) NOT NULL UNIQUE,
    FOREIGN KEY ([UserId]) REFERENCES Users (Id)
)
CREATE TABLE [dbo].[Principals]
(
    [Id]          [varchar](36) NOT NULL PRIMARY KEY,
    [UserId]     [varchar](36) NOT NULL UNIQUE,
    [IsVerified] [bit]         NOT NULL,
    FOREIGN KEY ([UserId]) REFERENCES Users (Id)
)

CREATE TABLE [dbo].[Teachers]
(
    [Id]      [varchar](36) NOT NULL PRIMARY KEY,
    [UserId] [varchar](36) NOT NULL UNIQUE,
    FOREIGN KEY ([UserId]) REFERENCES Users (Id)
)

CREATE TABLE [dbo].[Groups]
(
    [Id]         [varchar](36) NOT NULL PRIMARY KEY,
    [Grade]      [smallint]    NOT NULL CHECK (([Grade] = (12) OR
                                                [Grade] = (11) OR
                                                [Grade] = (10) OR
                                                [Grade] = (9) OR
                                                [Grade] = (8) OR
                                                [Grade] = (7) OR
                                                [Grade] = (6) OR
                                                [Grade] = (5) OR
                                                [Grade] = (4) OR
                                                [Grade] = (3) OR
                                                [Grade] = (2) OR
                                                [Grade] = (1))),
    [Letter]     [nchar](1)    NULL,
    [TeacherId] [varchar](36) NOT NULL UNIQUE,
    FOREIGN KEY (TeacherId) REFERENCES Teachers (Id)
)

CREATE TABLE [dbo].[Students]
(
    [Id]       [varchar](36) NOT NULL PRIMARY KEY,
    [UserId]  [varchar](36) NOT NULL UNIQUE,
    [GroupId] [varchar](36) NOT NULL,
    FOREIGN KEY ([UserId]) REFERENCES Users (Id),
    FOREIGN KEY ([GroupId]) REFERENCES Groups (Id)
)
CREATE TABLE [dbo].[Tasks]
(
    [Id]           [varchar](36)   NOT NULL PRIMARY KEY,
    [Name]         [nvarchar](255) NULL,
    [Description]  [nvarchar](max) NULL,
    [DateCreated] [datetime2](0)  NOT NULL,
    [DueDate]     [datetime2](0)  NOT NULL,
    [TeacherId]   [varchar](36)   NOT NULL,
    FOREIGN KEY (TeacherId) REFERENCES Teachers (Id)
)

CREATE TABLE [dbo].[Files]
(
    [Id]           [varchar](36)    NOT NULL PRIMARY KEY,
    [FileContent] [varbinary](max) NOT NULL,
    [TaskId]      [varchar](36)    NOT NULL,
    FOREIGN KEY ([TaskId]) REFERENCES Tasks (Id)
)

CREATE TABLE [dbo].[PendingUpdates]
(
    [Id]           [varchar](36)    NOT NULL PRIMARY KEY,
    [Username]     [varchar](150)   NOT NULL UNIQUE,
    [Password]     [varbinary](max) NOT NULL,
    [Email]        [varchar](255)   NOT NULL UNIQUE,
    [FirstName]   [nvarchar](100)  NOT NULL,
    [LastName]    [nvarchar](100)  NOT NULL,
    [ChangesMade] datetime2(0)     NOT NULL,
    [AdminId]     [varchar](36)    NOT NULL,
    [UserId]      [varchar](36)    NOT NULL UNIQUE,
    FOREIGN KEY ([UserId]) REFERENCES Users (Id),
    FOREIGN KEY ([AdminId]) REFERENCES Admins (Id)
)
CREATE TABLE [dbo].[Projects]
(
    [Id]           [varchar](36)   NOT NULL PRIMARY KEY,
    [Name]         [nvarchar](255) NULL,
    [Description]  [nvarchar](max) NULL,
    [DateCreated] [datetime2](0)  NOT NULL,
    [DueDate]     [datetime2](0)  NOT NULL,
    [AdminId]     [varchar](36)   NOT NULL,
    FOREIGN KEY ([AdminId]) REFERENCES Admins (Id)
)
CREATE TABLE [dbo].[Sessions]
(
    [Id]           [varchar](36) NOT NULL PRIMARY KEY,
    [RoleName]    [varchar](20) NOT NULL
        CHECK (([RoleName] = 'admin' OR
                [RoleName] = 'student' OR
                [RoleName] = 'teacher' OR
                [RoleName] = 'principal')),
    [TimeCreated] datetime2(0)  NOT NULL,
    [UserId]      [varchar](36) NOT NULL UNIQUE,
    FOREIGN KEY ([UserId]) REFERENCES Users (Id)
)
CREATE TABLE [dbo].[StudentsTasks]
(
    [StudentId] [varchar](36) NOT NULL,
    [TaskId]    [varchar](36) NOT NULL,
    PRIMARY KEY ([StudentId], [TaskId]),
    FOREIGN KEY ([StudentId]) REFERENCES Students (Id),
    FOREIGN KEY ([TaskId]) REFERENCES Tasks (Id),
)

CREATE TABLE [dbo].[Teams]
(
    [Id]   [varchar](36)   NOT NULL PRIMARY KEY,
    [Name] [nvarchar](100) NOT NULL UNIQUE,
)

CREATE TABLE [dbo].[StudentsTeams]
(
    [StudentId] [varchar](36) NOT NULL,
    [TeamId]    [varchar](36) NOT NULL,
    PRIMARY KEY ([StudentId], [TeamId]),
    FOREIGN KEY ([StudentId]) REFERENCES Students (Id),
    FOREIGN KEY ([TeamId]) REFERENCES Teams (Id)
)

CREATE TABLE [dbo].[TeamsProjects]
(
    [ProjectId] [varchar](36) NOT NULL,
    [TeamId]    [varchar](36) NOT NULL,
    PRIMARY KEY ([ProjectId], [TeamId]),
    FOREIGN KEY ([ProjectId]) REFERENCES Projects (Id),
    FOREIGN KEY ([TeamId]) REFERENCES Teams (Id)
)


