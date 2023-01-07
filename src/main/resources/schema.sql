USE [StudentsAndTeachers]
GO
/****** Object:  User [SakamDiploma]    Script Date: 1/7/2023 1:28:38 PM ******/
CREATE USER [SakamDiploma] FOR LOGIN [diplomaIskam] WITH DEFAULT_SCHEMA=[db_owner]
GO
ALTER ROLE [db_owner] ADD MEMBER [SakamDiploma]
GO
ALTER ROLE [db_accessadmin] ADD MEMBER [SakamDiploma]
GO
ALTER ROLE [db_securityadmin] ADD MEMBER [SakamDiploma]
GO
ALTER ROLE [db_ddladmin] ADD MEMBER [SakamDiploma]
GO
ALTER ROLE [db_backupoperator] ADD MEMBER [SakamDiploma]
GO
ALTER ROLE [db_datareader] ADD MEMBER [SakamDiploma]
GO
ALTER ROLE [db_datawriter] ADD MEMBER [SakamDiploma]
GO
ALTER ROLE [db_denydatareader] ADD MEMBER [SakamDiploma]
GO
ALTER ROLE [db_denydatawriter] ADD MEMBER [SakamDiploma]
GO
/****** Object:  Table [dbo].[Classes]    Script Date: 1/7/2023 1:28:38 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Classes](
                                [ID] [int] IDENTITY(1,1) NOT NULL,
                                [Grade] [smallint] NOT NULL,
                                [Letter] [nchar](1) NOT NULL,
                                [TeacherID] [int] NOT NULL,
                                PRIMARY KEY CLUSTERED
                                    (
                                     [ID] ASC
                                        )WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
                                UNIQUE NONCLUSTERED
                                    (
                                     [TeacherID] ASC
                                        )WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Parents]    Script Date: 1/7/2023 1:28:38 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Parents](
                                [ID] [int] IDENTITY(1,1) NOT NULL,
                                [FirstName] [nvarchar](100) NOT NULL,
                                [LastName] [nvarchar](100) NOT NULL,
                                [Email] [varchar](255) NOT NULL,
                                [PhoneNumber] [varbinary](max) NOT NULL,
                                [Address] [varbinary](max) NOT NULL,
                                PRIMARY KEY CLUSTERED
                                    (
                                     [ID] ASC
                                        )WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Principals]    Script Date: 1/7/2023 1:28:38 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Principals](
                                   [ID] [int] IDENTITY(1,1) NOT NULL,
                                   [UserID] [int] NOT NULL,
                                   [IsVerified] [bit] NOT NULL,
                                   PRIMARY KEY CLUSTERED
                                       (
                                        [ID] ASC
                                           )WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
                                   UNIQUE NONCLUSTERED
                                       (
                                        [UserID] ASC
                                           )WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Projects]    Script Date: 1/7/2023 1:28:38 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Projects](
                                 [ID] [int] IDENTITY(1,1) NOT NULL,
                                 [Name] [nvarchar](255) NOT NULL,
                                 [Description] [ntext] NOT NULL,
                                 [DateCreated] [datetime2](7) NOT NULL,
                                 [DueDate] [datetime2](7) NOT NULL,
                                 PRIMARY KEY CLUSTERED
                                     (
                                      [ID] ASC
                                         )WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Schools]    Script Date: 1/7/2023 1:28:38 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Schools](
                                [ID] [int] IDENTITY(1,1) NOT NULL,
                                [Name] [nvarchar](255) NOT NULL,
                                [Address] [nvarchar](255) NOT NULL,
                                PRIMARY KEY CLUSTERED
                                    (
                                     [ID] ASC
                                        )WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Students]    Script Date: 1/7/2023 1:28:38 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Students](
                                 [ID] [int] IDENTITY(1,1) NOT NULL,
                                 [UserID] [int] NOT NULL,
                                 [ParentID] [int] NOT NULL,
                                 PRIMARY KEY CLUSTERED
                                     (
                                      [ID] ASC
                                         )WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
                                 UNIQUE NONCLUSTERED
                                     (
                                      [UserID] ASC
                                         )WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
                                 UNIQUE NONCLUSTERED
                                     (
                                      [ParentID] ASC
                                         )WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[StudentsClasses]    Script Date: 1/7/2023 1:28:38 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[StudentsClasses](
                                        [ID] [int] IDENTITY(1,1) NOT NULL,
                                        [StudentID] [int] NOT NULL,
                                        [ClassID] [int] NOT NULL,
                                        PRIMARY KEY CLUSTERED
                                            (
                                             [ID] ASC
                                                )WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[StudentsTasks]    Script Date: 1/7/2023 1:28:38 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[StudentsTasks](
                                      [ID] [int] IDENTITY(1,1) NOT NULL,
                                      [StudentID] [int] NOT NULL,
                                      [TaskID] [int] NOT NULL,
                                      PRIMARY KEY CLUSTERED
                                          (
                                           [ID] ASC
                                              )WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[StudentsTeams]    Script Date: 1/7/2023 1:28:38 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[StudentsTeams](
                                      [ID] [int] IDENTITY(1,1) NOT NULL,
                                      [StudentID] [int] NOT NULL,
                                      [TeamID] [int] NOT NULL,
                                      PRIMARY KEY CLUSTERED
                                          (
                                           [ID] ASC
                                              )WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Tasks]    Script Date: 1/7/2023 1:28:38 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Tasks](
                              [ID] [int] IDENTITY(1,1) NOT NULL,
                              [Name] [nvarchar](255) NOT NULL,
                              [Description] [ntext] NOT NULL,
                              [DateCreated] [datetime2](7) NOT NULL,
                              [DueDate] [datetime2](7) NOT NULL,
                              [TeacherID] [int] NOT NULL,
                              PRIMARY KEY CLUSTERED
                                  (
                                   [ID] ASC
                                      )WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Teachers]    Script Date: 1/7/2023 1:28:38 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Teachers](
                                 [ID] [int] IDENTITY(1,1) NOT NULL,
                                 [UserID] [int] NOT NULL,
                                 PRIMARY KEY CLUSTERED
                                     (
                                      [ID] ASC
                                         )WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
                                 UNIQUE NONCLUSTERED
                                     (
                                      [UserID] ASC
                                         )WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Teams]    Script Date: 1/7/2023 1:28:38 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Teams](
                              [ID] [int] IDENTITY(1,1) NOT NULL,
                              [Name] [nvarchar](255) NOT NULL,
                              PRIMARY KEY CLUSTERED
                                  (
                                   [ID] ASC
                                      )WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TeamsProjects]    Script Date: 1/7/2023 1:28:38 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TeamsProjects](
                                      [ID] [int] IDENTITY(1,1) NOT NULL,
                                      [ProjectID] [int] NOT NULL,
                                      [TeamID] [int] NOT NULL,
                                      PRIMARY KEY CLUSTERED
                                          (
                                           [ID] ASC
                                              )WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Users]    Script Date: 1/7/2023 1:28:38 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Users](
                              [ID] [int] IDENTITY(1,1) NOT NULL,
                              [Username] [nvarchar](255) NOT NULL,
                              [Password] [varbinary](max) NOT NULL,
                              [FirstName] [nvarchar](100) NOT NULL,
                              [LastName] [nvarchar](100) NOT NULL,
                              [Email] [varchar](255) NOT NULL,
                              [SchoolID] [int] NOT NULL,
                              PRIMARY KEY CLUSTERED
                                  (
                                   [ID] ASC
                                      )WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
                              CONSTRAINT [UK_Username] UNIQUE NONCLUSTERED
                                  (
                                   [Username] ASC
                                      )WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
                              UNIQUE NONCLUSTERED
                                  (
                                   [Email] ASC
                                      )WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
ALTER TABLE [dbo].[Principals] ADD  DEFAULT ((0)) FOR [IsVerified]
GO
ALTER TABLE [dbo].[Projects] ADD  DEFAULT (getdate()) FOR [DateCreated]
GO
ALTER TABLE [dbo].[Projects] ADD  DEFAULT (getdate()+(7)) FOR [DueDate]
GO
ALTER TABLE [dbo].[Tasks] ADD  DEFAULT (getdate()) FOR [DateCreated]
GO
ALTER TABLE [dbo].[Tasks] ADD  DEFAULT (getdate()+(1)) FOR [DueDate]
GO
ALTER TABLE [dbo].[Classes]  WITH CHECK ADD  CONSTRAINT [FK_Classes_Teachers] FOREIGN KEY([TeacherID])
    REFERENCES [dbo].[Teachers] ([ID])
GO
ALTER TABLE [dbo].[Classes] CHECK CONSTRAINT [FK_Classes_Teachers]
GO
ALTER TABLE [dbo].[Principals]  WITH CHECK ADD  CONSTRAINT [FK_Principals_Users] FOREIGN KEY([UserID])
    REFERENCES [dbo].[Users] ([ID])
GO
ALTER TABLE [dbo].[Principals] CHECK CONSTRAINT [FK_Principals_Users]
GO
ALTER TABLE [dbo].[Students]  WITH CHECK ADD  CONSTRAINT [FK_Students_Parents] FOREIGN KEY([ParentID])
    REFERENCES [dbo].[Parents] ([ID])
GO
ALTER TABLE [dbo].[Students] CHECK CONSTRAINT [FK_Students_Parents]
GO
ALTER TABLE [dbo].[Students]  WITH CHECK ADD  CONSTRAINT [FK_Students_Users] FOREIGN KEY([UserID])
    REFERENCES [dbo].[Users] ([ID])
GO
ALTER TABLE [dbo].[Students] CHECK CONSTRAINT [FK_Students_Users]
GO
ALTER TABLE [dbo].[StudentsClasses]  WITH NOCHECK ADD FOREIGN KEY([ClassID])
    REFERENCES [dbo].[Classes] ([ID])
GO
ALTER TABLE [dbo].[StudentsClasses]  WITH NOCHECK ADD FOREIGN KEY([StudentID])
    REFERENCES [dbo].[Students] ([ID])
GO
ALTER TABLE [dbo].[StudentsTasks]  WITH NOCHECK ADD FOREIGN KEY([StudentID])
    REFERENCES [dbo].[Students] ([ID])
GO
ALTER TABLE [dbo].[StudentsTasks]  WITH NOCHECK ADD FOREIGN KEY([TaskID])
    REFERENCES [dbo].[Tasks] ([ID])
GO
ALTER TABLE [dbo].[StudentsTeams]  WITH NOCHECK ADD FOREIGN KEY([StudentID])
    REFERENCES [dbo].[Students] ([ID])
GO
ALTER TABLE [dbo].[StudentsTeams]  WITH NOCHECK ADD FOREIGN KEY([TeamID])
    REFERENCES [dbo].[Teams] ([ID])
GO
ALTER TABLE [dbo].[Tasks]  WITH NOCHECK ADD FOREIGN KEY([TeacherID])
    REFERENCES [dbo].[Teachers] ([ID])
GO
ALTER TABLE [dbo].[Teachers]  WITH CHECK ADD  CONSTRAINT [FK_Teachers_Users] FOREIGN KEY([UserID])
    REFERENCES [dbo].[Users] ([ID])
GO
ALTER TABLE [dbo].[Teachers] CHECK CONSTRAINT [FK_Teachers_Users]
GO
ALTER TABLE [dbo].[TeamsProjects]  WITH NOCHECK ADD FOREIGN KEY([ProjectID])
    REFERENCES [dbo].[Projects] ([ID])
GO
ALTER TABLE [dbo].[TeamsProjects]  WITH NOCHECK ADD FOREIGN KEY([TeamID])
    REFERENCES [dbo].[Teams] ([ID])
GO
ALTER TABLE [dbo].[Users]  WITH NOCHECK ADD FOREIGN KEY([SchoolID])
    REFERENCES [dbo].[Schools] ([ID])
GO
/****** Object:  StoredProcedure [dbo].[InsertParent]    Script Date: 1/7/2023 1:28:38 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		pak az
-- Create date: pak dnes
-- Description:	pak testvam
-- =============================================
CREATE PROCEDURE [dbo].[InsertParent]
    -- Add the parameters for the stored procedure here
    @FirstName nvarchar(100),
    @LastName nvarchar(100),
    @Email varchar(255),
    @PhoneNumber varchar(10),
    @Address nvarchar(255)
AS
BEGIN
    SET NOCOUNT ON;

    INSERT INTO Parents(FirstName,LastName,Email,PhoneNumber,[Address])
    VALUES(
              @FirstName,
              @LastName,
              @Email,
              CONVERT(varbinary(MAX),@PhoneNumber),
              CONVERT(varbinary(MAX),@Address)
          )

END
GO
/****** Object:  StoredProcedure [dbo].[InsertUser]    Script Date: 1/7/2023 1:28:38 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		nqma poveche da pisha
-- Create date: tochno predi da vlqza na zashtita
-- Description:	naistina iskam 6
-- =============================================
CREATE PROCEDURE [dbo].[InsertUser]
    -- Add the parameters for the stored procedure here
    @Username varchar(255),
    @Password varchar(MAX),
    @FirstName nvarchar(100),
    @LastName nvarchar(100),
    @Email varchar(255),
    @SchoolID int
AS
BEGIN
    SET NOCOUNT ON;

    INSERT INTO Users(Username,[Password],FirstName,LastName,Email,SchoolID)
    VALUES(
              @Username,
              CONVERT(varbinary(MAX),@Password),
              @FirstName,
              @LastName,
              @Email,
              @SchoolID)
END
GO
USE [master]
GO
ALTER DATABASE [StudentsAndTeachers] SET  READ_WRITE
GO

-- =============================================
-- Author:		az mi koi da e
-- Create date: epa dnes koga da e
-- Description:	testvam dali raboti
-- =============================================
CREATE OR ALTER TRIGGER [dbo].[EncryptParentData]
   ON  [dbo].[Parents]
   INSTEAD OF INSERT
AS 
BEGIN
	SET NOCOUNT ON;

	INSERT INTO Parents(FirstName,LastName,Email,PhoneNumber,[Address])
	SELECT 
		i.FirstName,
		i.LastName,
		i.Email,
		ENCRYPTBYPASSPHRASE('iskam_6_ot_komisiqta_molq',i.PhoneNumber),
		ENCRYPTBYPASSPHRASE('iskam_6_ot_komisiqta_molq',i.[Address])
	FROM inserted AS i

END
GO

ALTER TABLE [dbo].[Parents] ENABLE TRIGGER [EncryptParentData]
GO


USE [StudentsAndTeachers]
GO

/****** Object:  Trigger [dbo].[HashPassword]    Script Date: 1/7/2023 12:02:06 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

-- =============================================
-- Author:		poznai ot 3tiq put
-- Create date: utre
-- Description:	onui sraboti
-- =============================================
CREATE OR ALTER TRIGGER [dbo].[HashPassword] 
   ON  [dbo].[Users] 
   INSTEAD OF INSERT
AS 
BEGIN
	SET NOCOUNT ON;

    INSERT INTO Users(Username,[Password],FirstName,LastName,Email,SchoolID)
	SELECT
		i.Username,
		HASHBYTES('SHA2_512',i.[Password]),
		i.FirstName,
		i.LastName,
		i.Email,
		i.SchoolID
	FROM inserted AS i

END
GO

ALTER TABLE [dbo].[Users] ENABLE TRIGGER [HashPassword]
GO


