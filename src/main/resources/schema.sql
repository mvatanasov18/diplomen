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
    [username]   [varchar](150)  NOT NULL UNIQUE,
    [password]   [varchar](500)  NOT NULL,
    [email]      [varchar](255)  NOT NULL UNIQUE,
    [first_name] [nvarchar](100) NOT NULL,
    [last_name]  [nvarchar](100) NOT NULL,
    [school_id]  [varchar](36)   NOT NULL,
    salt         varbinary(16)   NOT NULL,
    FOREIGN KEY ([school_id]) REFERENCES Schools (id)
)

CREATE TABLE [dbo].[Admins]
(
    [id]      [varchar](36) NOT NULL PRIMARY KEY,
    [user_id] [varchar](36) NOT NULL UNIQUE,
    FOREIGN KEY ([user_id]) REFERENCES Users (id)
)
CREATE TABLE [dbo].[Principals]
(
    [id]          [varchar](36) NOT NULL PRIMARY KEY,
    [user_id]     [varchar](36) NOT NULL UNIQUE,
    [is_verified] [bit]         NOT NULL,
    FOREIGN KEY ([user_id]) REFERENCES Users (id)
)

CREATE TABLE [dbo].[Teachers]
(
    [id]      [varchar](36) NOT NULL PRIMARY KEY,
    [user_id] [varchar](36) NOT NULL UNIQUE,
    FOREIGN KEY ([user_id]) REFERENCES Users (id)
)

CREATE TABLE [dbo].[Groups]
(
    [id]         [varchar](36) NOT NULL PRIMARY KEY,
    [grade]      [smallint]    NOT NULL CHECK (([grade] = (12) OR
                                                [grade] = (11) OR
                                                [grade] = (10) OR
                                                [grade] = (9) OR
                                                [grade] = (8) OR
                                                [grade] = (7) OR
                                                [grade] = (6) OR
                                                [grade] = (5) OR
                                                [grade] = (4) OR
                                                [grade] = (3) OR
                                                [grade] = (2) OR
                                                [grade] = (1))),
    [letter]     [nchar](1)    NULL,
    [teacher_id] [varchar](36) NOT NULL UNIQUE,
    FOREIGN KEY (teacher_id) REFERENCES Teachers (id)
)

CREATE TABLE [dbo].[Students]
(
    [id]       [varchar](36) NOT NULL PRIMARY KEY,
    [user_id]  [varchar](36) NOT NULL UNIQUE,
    [group_id] [varchar](36) NOT NULL,
    FOREIGN KEY ([user_id]) REFERENCES Users (id),
    FOREIGN KEY ([group_id]) REFERENCES Groups (id)
)
CREATE TABLE [dbo].[Tasks]
(
    [id]           [varchar](36)   NOT NULL PRIMARY KEY,
    [name]         [nvarchar](255) NULL,
    [description]  [nvarchar](max) NULL,
    [date_created] [datetime2](0)  NOT NULL,
    [due_date]     [datetime2](0)  NOT NULL,
    [teacher_id]   [varchar](36)   NOT NULL,
    FOREIGN KEY (teacher_id) REFERENCES Teachers (id)
)

CREATE TABLE [dbo].[Files]
(
    [id]           [varchar](36)    NOT NULL PRIMARY KEY,
    [file_content] [varbinary](max) NOT NULL,
    [task_id]      [varchar](36)    NOT NULL,
    FOREIGN KEY ([task_id]) REFERENCES Tasks (id)
)

CREATE TABLE [dbo].[PendingUpdates]
(
    [id]           [varchar](36)    NOT NULL PRIMARY KEY,
    [username]     [varchar](150)   NOT NULL UNIQUE,
    [password]     [varbinary](max) NOT NULL,
    [email]        [varchar](255)   NOT NULL UNIQUE,
    [first_name]   [nvarchar](100)  NOT NULL,
    [last_name]    [nvarchar](100)  NOT NULL,
    [changes_made] datetime2(0)     NOT NULL,
    [admin_id]     [varchar](36)    NOT NULL,
    [user_id]      [varchar](36)    NOT NULL UNIQUE,
    FOREIGN KEY ([user_id]) REFERENCES Users (id),
    FOREIGN KEY ([admin_id]) REFERENCES Admins (id)
)
CREATE TABLE [dbo].[Projects]
(
    [id]           [varchar](36)   NOT NULL PRIMARY KEY,
    [name]         [nvarchar](255) NULL,
    [description]  [nvarchar](max) NULL,
    [date_created] [datetime2](0)  NOT NULL,
    [due_date]     [datetime2](0)  NOT NULL,
    [admin_id]     [varchar](36)   NOT NULL,
    FOREIGN KEY ([admin_id]) REFERENCES Admins (id)
)
CREATE TABLE [dbo].[Sessions]
(
    [id]           [varchar](36) NOT NULL PRIMARY KEY,
    [role_name]    [varchar](20) NOT NULL
        CHECK (([role_name] = 'admin' OR
                [role_name] = 'student' OR
                [role_name] = 'teacher' OR
                [role_name] = 'principal')),
    [time_created] datetime2(0)  NOT NULL,
    [user_id]      [varchar](36) NOT NULL UNIQUE,
    FOREIGN KEY ([user_id]) REFERENCES Users (id)
)
CREATE TABLE [dbo].[StudentsTasks]
(
    [student_id] [varchar](36) NOT NULL,
    [task_id]    [varchar](36) NOT NULL,
    PRIMARY KEY ([student_id], [task_id]),
    FOREIGN KEY ([student_id]) REFERENCES Students (id),
    FOREIGN KEY ([task_id]) REFERENCES Tasks (id),
)

CREATE TABLE [dbo].[Teams]
(
    [id]   [varchar](36)   NOT NULL PRIMARY KEY,
    [name] [nvarchar](100) NOT NULL UNIQUE,
)

CREATE TABLE [dbo].[StudentsTeams]
(
    [student_id] [varchar](36) NOT NULL,
    [team_id]    [varchar](36) NOT NULL,
    PRIMARY KEY ([student_id], [Team_id]),
    FOREIGN KEY ([student_id]) REFERENCES Students (id),
    FOREIGN KEY ([team_id]) REFERENCES Teams (id)
)

CREATE TABLE [dbo].[TeamsProjects]
(
    [project_id] [varchar](36) NOT NULL,
    [team_id]    [varchar](36) NOT NULL,
    PRIMARY KEY ([project_id], [team_id]),
    FOREIGN KEY ([project_id]) REFERENCES Projects (id),
    FOREIGN KEY ([team_id]) REFERENCES Teams (id)
)


