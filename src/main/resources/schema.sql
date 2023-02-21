USE [master]
GO
/****** Object:  Database [StudentsAndTeachers]    Script Date: 2/21/2023 10:02:31 AM ******/
CREATE DATABASE [StudentsAndTeachers]
 CONTAINMENT = NONE
 ON  PRIMARY
( NAME = N'StudentsAndTeachers', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\StudentsAndTeachers.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON
( NAME = N'StudentsAndTeachers_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\StudentsAndTeachers_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
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
ALTER DATABASE [StudentsAndTeachers] SET CURSOR_DEFAULT  GLOBAL
GO
ALTER DATABASE [StudentsAndTeachers] SET CONCAT_NULL_YIELDS_NULL OFF
GO
ALTER DATABASE [StudentsAndTeachers] SET NUMERIC_ROUNDABORT OFF
GO
ALTER DATABASE [StudentsAndTeachers] SET QUOTED_IDENTIFIER OFF
GO
ALTER DATABASE [StudentsAndTeachers] SET RECURSIVE_TRIGGERS OFF
GO
ALTER DATABASE [StudentsAndTeachers] SET  DISABLE_BROKER
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
ALTER DATABASE [StudentsAndTeachers] SET  MULTI_USER
GO
ALTER DATABASE [StudentsAndTeachers] SET PAGE_VERIFY CHECKSUM
GO
ALTER DATABASE [StudentsAndTeachers] SET DB_CHAINING OFF
GO
ALTER DATABASE [StudentsAndTeachers] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF )
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
/****** Object:  User [IskamDiploma]    Script Date: 2/21/2023 10:02:31 AM ******/
CREATE USER [IskamDiploma] FOR LOGIN [diplomaIskam] WITH DEFAULT_SCHEMA=[db_owner]
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
/****** Object:  Table [dbo].[Addresses]    Script Date: 2/21/2023 10:02:32 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Addresses](
    [Id] [varchar](36) NOT NULL,
    [City] [nvarchar](100) NOT NULL,
    [house_number] [int] NOT NULL,
    [Street] [nvarchar](100) NOT NULL,
    [additional_info] [nvarchar](100) NULL,
    PRIMARY KEY CLUSTERED
(
[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[Admins]    Script Date: 2/21/2023 10:02:32 AM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[Admins](
    [Id] [varchar](36) NOT NULL,
    [User_Id] [varchar](36) NOT NULL,
    PRIMARY KEY CLUSTERED
(
[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
    UNIQUE NONCLUSTERED
(
[User_Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[Files]    Script Date: 2/21/2023 10:02:32 AM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[Files](
    [Id] [varchar](36) NOT NULL,
    [File_Content] [varbinary](max) NOT NULL,
    [Task_Id] [varchar](36) NOT NULL,
    PRIMARY KEY CLUSTERED
(
[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[Groups]    Script Date: 2/21/2023 10:02:32 AM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[Groups](
    [Id] [varchar](36) NOT NULL,
    [Grade] [smallint] NOT NULL,
    [Letter] [nchar](1) NULL,
    [Teacher_Id] [varchar](36) NOT NULL,
    PRIMARY KEY CLUSTERED
(
[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
    UNIQUE NONCLUSTERED
(
[Teacher_Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[Parents]    Script Date: 2/21/2023 10:02:32 AM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[Parents](
    [Id] [varchar](36) NOT NULL,
    [First_Name] [nvarchar](100) NOT NULL,
    [Last_Name] [nvarchar](100) NOT NULL,
    [Email] [varchar](255) NOT NULL,
    [Phone_Number] [varchar](10) NOT NULL,
    [Address_Id] [varchar](36) NOT NULL,
    PRIMARY KEY CLUSTERED
(
[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
    UNIQUE NONCLUSTERED
(
[Address_Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
    UNIQUE NONCLUSTERED
(
[Phone_Number] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
    UNIQUE NONCLUSTERED
(
[Email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[PendingUpdates]    Script Date: 2/21/2023 10:02:32 AM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[PendingUpdates](
    [Id] [varchar](36) NOT NULL,
    [Username] [varchar](150) NOT NULL,
    [Password] [varbinary](max) NOT NULL,
    [Email] [varchar](255) NOT NULL,
    [First_Name] [nvarchar](100) NOT NULL,
    [Last_Name] [nvarchar](100) NOT NULL,
    [Changes_Made] [timestamp] NOT NULL,
    [Admin_Id] [varchar](36) NOT NULL,
    [User_Id] [varchar](36) NOT NULL,
    PRIMARY KEY CLUSTERED
(
[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
    UNIQUE NONCLUSTERED
(
[User_Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
    UNIQUE NONCLUSTERED
(
[Username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
    UNIQUE NONCLUSTERED
(
[Email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[Principals]    Script Date: 2/21/2023 10:02:32 AM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[Principals](
    [Id] [varchar](36) NOT NULL,
    [User_Id] [varchar](36) NOT NULL,
    [Is_Verified] [bit] NOT NULL,
    PRIMARY KEY CLUSTERED
(
[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
    UNIQUE NONCLUSTERED
(
[User_Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[Projects]    Script Date: 2/21/2023 10:02:32 AM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[Projects](
    [Id] [varchar](36) NOT NULL,
    [Name] [nvarchar](255) NULL,
    [Description] [nvarchar](max) NULL,
    [Date_Created] [datetime2](0) NOT NULL,
    [Due_Date] [datetime2](0) NOT NULL,
    [Admin_Id] [varchar](36) NOT NULL,
    PRIMARY KEY CLUSTERED
(
[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
    UNIQUE NONCLUSTERED
(
[Name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[Schools]    Script Date: 2/21/2023 10:02:32 AM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[Schools](
    [Id] [varchar](36) NOT NULL,
    [Name] [nvarchar](255) NOT NULL,
    [Address_Id] [varchar](36) NOT NULL,
    PRIMARY KEY CLUSTERED
(
[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
    UNIQUE NONCLUSTERED
(
[Address_Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
    UNIQUE NONCLUSTERED
(
[Name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[Students]    Script Date: 2/21/2023 10:02:32 AM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[Students](
    [Id] [varchar](36) NOT NULL,
    [User_Id] [varchar](36) NOT NULL,
    [Parent_Id] [varchar](36) NOT NULL,
    [Group_Id] [varchar](36) NOT NULL,
    PRIMARY KEY CLUSTERED
(
[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
    UNIQUE NONCLUSTERED
(
[User_Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[StudentsTasks]    Script Date: 2/21/2023 10:02:32 AM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[StudentsTasks](
    [Student_Id] [varchar](36) NOT NULL,
    [Task_Id] [varchar](36) NOT NULL,
    PRIMARY KEY CLUSTERED
(
    [Student_Id] ASC,
[Task_Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[StudentsTeams]    Script Date: 2/21/2023 10:02:32 AM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[StudentsTeams](
    [Student_Id] [varchar](36) NOT NULL,
    [Team_Id] [varchar](36) NOT NULL,
    PRIMARY KEY CLUSTERED
(
    [Student_Id] ASC,
[Team_Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[Tasks]    Script Date: 2/21/2023 10:02:32 AM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[Tasks](
    [Id] [varchar](36) NOT NULL,
    [Name] [nvarchar](255) NULL,
    [Description] [nvarchar](max) NULL,
    [Date_Created] [datetime2](0) NOT NULL,
    [Due_Date] [datetime2](0) NOT NULL,
    [Teacher_Id] [varchar](36) NOT NULL,
    PRIMARY KEY CLUSTERED
(
[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
    UNIQUE NONCLUSTERED
(
[Name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[Teachers]    Script Date: 2/21/2023 10:02:32 AM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[Teachers](
    [Id] [varchar](36) NOT NULL,
    [User_Id] [varchar](36) NOT NULL,
    PRIMARY KEY CLUSTERED
(
[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
    UNIQUE NONCLUSTERED
(
[User_Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[Teams]    Script Date: 2/21/2023 10:02:32 AM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[Teams](
    [Id] [varchar](36) NOT NULL,
    [Name] [nvarchar](100) NOT NULL,
    PRIMARY KEY CLUSTERED
(
[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
    UNIQUE NONCLUSTERED
(
[Name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[TeamsProjects]    Script Date: 2/21/2023 10:02:32 AM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[TeamsProjects](
    [Project_Id] [varchar](36) NOT NULL,
    [Team_Id] [varchar](36) NOT NULL,
    PRIMARY KEY CLUSTERED
(
    [Project_Id] ASC,
[Team_Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[Users]    Script Date: 2/21/2023 10:02:32 AM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[Users](
    [Id] [varchar](36) NOT NULL,
    [Username] [varchar](150) NOT NULL,
    [Password] [varbinary](max) NOT NULL,
    [Email] [varchar](255) NOT NULL,
    [First_Name] [nvarchar](100) NOT NULL,
    [Last_Name] [nvarchar](100) NOT NULL,
    [School_Id] [varchar](36) NOT NULL,
    PRIMARY KEY CLUSTERED
(
[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
    UNIQUE NONCLUSTERED
(
[Username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
    UNIQUE NONCLUSTERED
(
[Email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
    GO
ALTER TABLE [dbo].[Admins]  WITH CHECK ADD FOREIGN KEY([User_Id])
    REFERENCES [dbo].[Users] ([Id])
    GO
ALTER TABLE [dbo].[Files]  WITH CHECK ADD FOREIGN KEY([Task_Id])
    REFERENCES [dbo].[Tasks] ([Id])
    GO
ALTER TABLE [dbo].[Groups]  WITH CHECK ADD FOREIGN KEY([Teacher_Id])
    REFERENCES [dbo].[Teachers] ([Id])
    GO
ALTER TABLE [dbo].[Parents]  WITH CHECK ADD FOREIGN KEY([Address_Id])
    REFERENCES [dbo].[Addresses] ([Id])
    GO
ALTER TABLE [dbo].[PendingUpdates]  WITH CHECK ADD FOREIGN KEY([Admin_Id])
    REFERENCES [dbo].[Admins] ([Id])
    GO
ALTER TABLE [dbo].[PendingUpdates]  WITH CHECK ADD FOREIGN KEY([User_Id])
    REFERENCES [dbo].[Users] ([Id])
    GO
ALTER TABLE [dbo].[Principals]  WITH CHECK ADD FOREIGN KEY([User_Id])
    REFERENCES [dbo].[Users] ([Id])
    GO
ALTER TABLE [dbo].[Projects]  WITH CHECK ADD FOREIGN KEY([Admin_Id])
    REFERENCES [dbo].[Admins] ([Id])
    GO
ALTER TABLE [dbo].[Schools]  WITH CHECK ADD FOREIGN KEY([Address_Id])
    REFERENCES [dbo].[Addresses] ([Id])
    GO
ALTER TABLE [dbo].[Students]  WITH CHECK ADD FOREIGN KEY([Group_Id])
    REFERENCES [dbo].[Groups] ([Id])
    GO
ALTER TABLE [dbo].[Students]  WITH CHECK ADD FOREIGN KEY([Parent_Id])
    REFERENCES [dbo].[Parents] ([Id])
    GO
ALTER TABLE [dbo].[Students]  WITH CHECK ADD FOREIGN KEY([User_Id])
    REFERENCES [dbo].[Users] ([Id])
    GO
ALTER TABLE [dbo].[StudentsTasks]  WITH CHECK ADD FOREIGN KEY([Student_Id])
    REFERENCES [dbo].[Students] ([Id])
    GO
ALTER TABLE [dbo].[StudentsTasks]  WITH CHECK ADD FOREIGN KEY([Task_Id])
    REFERENCES [dbo].[Tasks] ([Id])
    GO
ALTER TABLE [dbo].[StudentsTeams]  WITH CHECK ADD FOREIGN KEY([Student_Id])
    REFERENCES [dbo].[Users] ([Id])
    GO
ALTER TABLE [dbo].[StudentsTeams]  WITH CHECK ADD FOREIGN KEY([Team_Id])
    REFERENCES [dbo].[Teams] ([Id])
    GO
ALTER TABLE [dbo].[Tasks]  WITH CHECK ADD FOREIGN KEY([Teacher_Id])
    REFERENCES [dbo].[Teachers] ([Id])
    GO
ALTER TABLE [dbo].[Teachers]  WITH CHECK ADD FOREIGN KEY([User_Id])
    REFERENCES [dbo].[Users] ([Id])
    GO
ALTER TABLE [dbo].[TeamsProjects]  WITH CHECK ADD FOREIGN KEY([Project_Id])
    REFERENCES [dbo].[Projects] ([Id])
    GO
ALTER TABLE [dbo].[TeamsProjects]  WITH CHECK ADD FOREIGN KEY([Team_Id])
    REFERENCES [dbo].[Teams] ([Id])
    GO
ALTER TABLE [dbo].[Users]  WITH CHECK ADD FOREIGN KEY([School_Id])
    REFERENCES [dbo].[Schools] ([Id])
    GO
ALTER TABLE [dbo].[Addresses]  WITH CHECK ADD  CONSTRAINT [CK__Addresses__House__693CA210] CHECK  (([house_number]>(0)))
    GO
ALTER TABLE [dbo].[Addresses] CHECK CONSTRAINT [CK__Addresses__House__693CA210]
    GO
ALTER TABLE [dbo].[Groups]  WITH CHECK ADD CHECK  (([Grade]=(12) OR [Grade]=(11) OR [Grade]=(10) OR [Grade]=(9) OR [Grade]=(8) OR [Grade]=(7) OR [Grade]=(6) OR [Grade]=(5) OR [Grade]=(4) OR [Grade]=(3) OR [Grade]=(2) OR [Grade]=(1)))
    GO
/****** Object:  StoredProcedure [dbo].[CheckPassword]    Script Date: 2/21/2023 10:02:32 AM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO

CREATE   PROCEDURE [dbo].[CheckPassword]

@Username varchar(150),
@Password varchar(255)
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
SELECT IIF(
                   HASHBYTES('SHA2_512',CONVERT(varbinary(MAX), @Password))=u.[Password],1,0)
FROM Users as u
WHERE u.Username=@Username
END
GO
/****** Object:  StoredProcedure [dbo].[InsertUser]    Script Date: 2/21/2023 10:02:32 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE   PROCEDURE [dbo].[InsertUser]
@Username varchar(150),
@Password varchar(150),
@Email varchar(255),
@FirstName varchar(100),
@LastName varchar(100),
@SchoolId varchar(36)
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

INSERT INTO Users(
    Username,
    [Password],
    Email,
    First_Name,
    Last_Name, School_Id)
VALUES(@Username,CONVERT(varbinary(MAX),@Password),@Email,@FirstName,@LastName,@SchoolId)
END
GO
USE [master]
GO
ALTER DATABASE [StudentsAndTeachers] SET  READ_WRITE
GO

USE [StudentsAndTeachers]
GO
/****** Object:  Trigger [dbo].[HashPassword]    Script Date: 2/21/2023 10:01:57 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

USE [StudentsAndTeachers]
ALTER   TRIGGER [dbo].[HashPassword]
ON  [dbo].[Users]
   INSTEAD OF INSERT
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

INSERT INTO Users(Username,[Password],Email,First_Name,Last_Name,
                  School_Id)
SELECT
    i.Username,
    HASHBYTES('SHA2_512' ,i.[Password]),
    i.Email,
    i.First_Name,
    i.Last_Name,
    i.School_Id
FROM inserted as i

END

