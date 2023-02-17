USE [master]
GO
/****** Object:  Database [StudentsAndTeachers]    Script Date: 2/8/2023 9:24:13 AM ******/
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
/****** Object:  Table [dbo].[Addresses]    Script Date: 2/8/2023 9:24:13 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Addresses](
    [Id] [varchar](36) NOT NULL,
    [City] [nvarchar](100) NOT NULL,
    [HouseNumber] [int] NOT NULL,
    [Street] [nvarchar](100) NOT NULL,
    [AdditionalInfo] [nvarchar](100) NULL,
    PRIMARY KEY CLUSTERED
(
[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[Admins]    Script Date: 2/8/2023 9:24:13 AM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[Admins](
    [Id] [varchar](36) NOT NULL,
    [UserId] [varchar](36) NOT NULL,
    PRIMARY KEY CLUSTERED
(
[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
    UNIQUE NONCLUSTERED
(
[UserId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[Files]    Script Date: 2/8/2023 9:24:13 AM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[Files](
    [Id] [varchar](36) NOT NULL,
    [FileContent] [varbinary](max) NOT NULL,
    [TaskId] [varchar](36) NOT NULL,
    PRIMARY KEY CLUSTERED
(
[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[Groups]    Script Date: 2/8/2023 9:24:13 AM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[Groups](
    [Id] [varchar](36) NOT NULL,
    [Grade] [smallint] NOT NULL,
    [Letter] [nchar](1) NULL,
    [TeacherId] [varchar](36) NOT NULL,
    PRIMARY KEY CLUSTERED
(
[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
    UNIQUE NONCLUSTERED
(
[TeacherId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[Parents]    Script Date: 2/8/2023 9:24:13 AM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[Parents](
    [Id] [varchar](36) NOT NULL,
    [FirstName] [nvarchar](100) NOT NULL,
    [LastName] [nvarchar](100) NOT NULL,
    [Email] [varchar](255) NOT NULL,
    [PhoneNumber] [varchar](10) NOT NULL,
    [AddressId] [varchar](36) NOT NULL,
    PRIMARY KEY CLUSTERED
(
[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
    UNIQUE NONCLUSTERED
(
[AddressId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
    UNIQUE NONCLUSTERED
(
[PhoneNumber] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
    UNIQUE NONCLUSTERED
(
[Email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[PendingUpdates]    Script Date: 2/8/2023 9:24:13 AM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[PendingUpdates](
    [Id] [varchar](36) NOT NULL,
    [Username] [varchar](150) NOT NULL,
    [Password] [varbinary](max) NOT NULL,
    [Email] [varchar](255) NOT NULL,
    [FirstName] [nvarchar](100) NOT NULL,
    [LastName] [nvarchar](100) NOT NULL,
    [ChangesMade] [timestamp] NOT NULL,
    [AdminId] [varchar](36) NOT NULL,
    [UserId] [varchar](36) NOT NULL,
    PRIMARY KEY CLUSTERED
(
[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
    UNIQUE NONCLUSTERED
(
[UserId] ASC
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
/****** Object:  Table [dbo].[Principals]    Script Date: 2/8/2023 9:24:13 AM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[Principals](
    [Id] [varchar](36) NOT NULL,
    [UserId] [varchar](36) NOT NULL,
    [IsVerified] [bit] NOT NULL,
    PRIMARY KEY CLUSTERED
(
[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
    UNIQUE NONCLUSTERED
(
[UserId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[Projects]    Script Date: 2/8/2023 9:24:13 AM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[Projects](
    [Id] [varchar](36) NOT NULL,
    [Name] [nvarchar](255) NULL,
    [Description] [nvarchar](max) NULL,
    [DateCreated] [datetime2](0) NOT NULL,
    [DueDate] [datetime2](0) NOT NULL,
    [AdminId] [varchar](36) NOT NULL,
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
/****** Object:  Table [dbo].[Schools]    Script Date: 2/8/2023 9:24:13 AM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[Schools](
    [Id] [varchar](36) NOT NULL,
    [Name] [nvarchar](255) NOT NULL,
    [AddressId] [varchar](36) NOT NULL,
    PRIMARY KEY CLUSTERED
(
[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
    UNIQUE NONCLUSTERED
(
[AddressId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
    UNIQUE NONCLUSTERED
(
[Name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[Students]    Script Date: 2/8/2023 9:24:13 AM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[Students](
    [Id] [varchar](36) NOT NULL,
    [UserId] [varchar](36) NOT NULL,
    [ParentId] [varchar](36) NOT NULL,
    [GroupId] [varchar](36) NOT NULL,
    PRIMARY KEY CLUSTERED
(
[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
    UNIQUE NONCLUSTERED
(
[UserId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO

/****** Object:  Table [dbo].[StudentsTasks]    Script Date: 2/8/2023 9:24:13 AM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[StudentsTasks](
    [StudentId] [varchar](36) NOT NULL,
    [TaskId] [varchar](36) NOT NULL,
    PRIMARY KEY CLUSTERED
(
    [StudentId] ASC,
[TaskId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[StudentsTeams]    Script Date: 2/8/2023 9:24:13 AM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[StudentsTeams](
    [StudentId] [varchar](36) NOT NULL,
    [TeamId] [varchar](36) NOT NULL,
    PRIMARY KEY CLUSTERED
(
    [StudentId] ASC,
[TeamId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[Tasks]    Script Date: 2/8/2023 9:24:13 AM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[Tasks](
    [Id] [varchar](36) NOT NULL,
    [Name] [nvarchar](255) NULL,
    [Description] [nvarchar](max) NULL,
    [DateCreated] [datetime2](0) NOT NULL,
    [DueDate] [datetime2](0) NOT NULL,
    [StudentId] [varchar](36) NOT NULL,
    [TeacherId] [varchar](36) NOT NULL,
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
/****** Object:  Table [dbo].[Teachers]    Script Date: 2/8/2023 9:24:13 AM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[Teachers](
    [Id] [varchar](36) NOT NULL,
    [UserId] [varchar](36) NOT NULL,
    PRIMARY KEY CLUSTERED
(
[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
    UNIQUE NONCLUSTERED
(
[UserId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[Teams]    Script Date: 2/8/2023 9:24:13 AM ******/
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
/****** Object:  Table [dbo].[TeamsProjects]    Script Date: 2/8/2023 9:24:13 AM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[TeamsProjects](
    [ProjectId] [varchar](36) NOT NULL,
    [TeamId] [varchar](36) NOT NULL,
    PRIMARY KEY CLUSTERED
(
    [ProjectId] ASC,
[TeamId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[Users]    Script Date: 2/8/2023 9:24:13 AM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[Users](
    [Id] [varchar](36) NOT NULL,
    [Username] [varchar](150) NOT NULL,
    [Password] [varbinary](max) NOT NULL,
    [Email] [varchar](255) NOT NULL,
    [FirstName] [nvarchar](100) NOT NULL,
    [LastName] [nvarchar](100) NOT NULL,
    [SchoolId] [varchar](36) NOT NULL,
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
ALTER TABLE [dbo].[Admins]  WITH CHECK ADD FOREIGN KEY([UserId])
    REFERENCES [dbo].[Users] ([Id])
    GO
ALTER TABLE [dbo].[Files]  WITH CHECK ADD FOREIGN KEY([TaskId])
    REFERENCES [dbo].[Tasks] ([Id])
    GO
ALTER TABLE [dbo].[Groups]  WITH CHECK ADD FOREIGN KEY([TeacherId])
    REFERENCES [dbo].[Teachers] ([Id])
    GO
ALTER TABLE [dbo].[Parents]  WITH CHECK ADD FOREIGN KEY([AddressId])
    REFERENCES [dbo].[Addresses] ([Id])
    GO
ALTER TABLE [dbo].[PendingUpdates]  WITH CHECK ADD FOREIGN KEY([AdminId])
    REFERENCES [dbo].[Admins] ([Id])
    GO
ALTER TABLE [dbo].[PendingUpdates]  WITH CHECK ADD FOREIGN KEY([UserId])
    REFERENCES [dbo].[Users] ([Id])
    GO
ALTER TABLE [dbo].[Principals]  WITH CHECK ADD FOREIGN KEY([UserId])
    REFERENCES [dbo].[Users] ([Id])
    GO
ALTER TABLE [dbo].[Projects]  WITH CHECK ADD FOREIGN KEY([AdminId])
    REFERENCES [dbo].[Admins] ([Id])
    GO
ALTER TABLE [dbo].[Schools]  WITH CHECK ADD FOREIGN KEY([AddressId])
    REFERENCES [dbo].[Addresses] ([Id])
    GO
ALTER TABLE [dbo].[Students]  WITH CHECK ADD FOREIGN KEY([ParentId])
    REFERENCES [dbo].[Parents] ([Id])
    GO
ALTER TABLE [dbo].[Students]  WITH CHECK ADD FOREIGN KEY([UserId])
    REFERENCES [dbo].[Users] ([Id])
    GO
ALTER TABLE [dbo].[StudentsTasks]  WITH CHECK ADD FOREIGN KEY([StudentId])
    REFERENCES [dbo].[Students] ([Id])
    GO
ALTER TABLE [dbo].[StudentsTasks]  WITH CHECK ADD FOREIGN KEY([TaskId])
    REFERENCES [dbo].[Tasks] ([Id])
    GO
ALTER TABLE [dbo].[StudentsTeams]  WITH CHECK ADD FOREIGN KEY([StudentId])
    REFERENCES [dbo].[Users] ([Id])
    GO
ALTER TABLE [dbo].[Students]  WITH CHECK ADD FOREIGN KEY([GroupId])
    REFERENCES [dbo].[Groups] ([Id])
    GO
ALTER TABLE [dbo].[StudentsTeams]  WITH CHECK ADD FOREIGN KEY([TeamId])
    REFERENCES [dbo].[Teams] ([Id])
    GO
ALTER TABLE [dbo].[Tasks]  WITH CHECK ADD FOREIGN KEY([StudentId])
    REFERENCES [dbo].[Students] ([Id])
    GO
ALTER TABLE [dbo].[Tasks]  WITH CHECK ADD FOREIGN KEY([TeacherId])
    REFERENCES [dbo].[Teachers] ([Id])
    GO
ALTER TABLE [dbo].[Teachers]  WITH CHECK ADD FOREIGN KEY([UserId])
    REFERENCES [dbo].[Users] ([Id])
    GO
ALTER TABLE [dbo].[TeamsProjects]  WITH CHECK ADD FOREIGN KEY([ProjectId])
    REFERENCES [dbo].[Projects] ([Id])
    GO
ALTER TABLE [dbo].[TeamsProjects]  WITH CHECK ADD FOREIGN KEY([TeamId])
    REFERENCES [dbo].[Teams] ([Id])
    GO
ALTER TABLE [dbo].[Users]  WITH CHECK ADD FOREIGN KEY([SchoolId])
    REFERENCES [dbo].[Schools] ([Id])
    GO
ALTER TABLE [dbo].[Addresses]  WITH CHECK ADD CHECK  (([HouseNumber]>(0)))
    GO
ALTER TABLE [dbo].[Groups]  WITH CHECK ADD CHECK  (([Grade]=(12) OR [Grade]=(11) OR [Grade]=(10) OR [Grade]=(9) OR [Grade]=(8) OR [Grade]=(7) OR [Grade]=(6) OR [Grade]=(5) OR [Grade]=(4) OR [Grade]=(3) OR [Grade]=(2) OR [Grade]=(1)))
    GO
/****** Object:  StoredProcedure [dbo].[CheckPassword]    Script Date: 2/8/2023 9:24:13 AM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO

CREATE OR ALTER PROCEDURE [dbo].[CheckPassword]

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
END
GO
/****** Object:  StoredProcedure [dbo].[InsertUser]    Script Date: 2/8/2023 9:24:13 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE OR ALTER PROCEDURE [dbo].[InsertUser]
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
    FirstName,
    LastName, SchoolId)
VALUES(@Username,CONVERT(varbinary(MAX),@Password),@Email,@FirstName,@LastName,@SchoolId)
END
GO
USE [master]
GO
ALTER DATABASE [StudentsAndTeachers] SET  READ_WRITE
GO

USE StudentsAndTeachers

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE OR ALTER TRIGGER HashPassword
ON  Users
   INSTEAD OF INSERT
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

INSERT INTO Users(Username,[Password],Email,FirstName,LastName,
                  SchoolId)
SELECT
    i.Username,
    HASHBYTES('SHA2_512' ,i.[Password]),
    i.Email,
    i.FirstName,
    i.LastName,
    i.SchoolId
FROM inserted as i

END
GO
