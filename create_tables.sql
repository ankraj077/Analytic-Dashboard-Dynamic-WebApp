USE [master]
GO
/****** Object:  Database [mycompanydatabase]    Script Date: 4/28/2017 11:23:38 PM ******/
CREATE DATABASE [mycompanydatabase]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'mycompanydatabase', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\mycompanydatabase.mdf' , SIZE = 4096KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'mycompanydatabase_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\mycompanydatabase_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [mycompanydatabase] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [mycompanydatabase].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [mycompanydatabase] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [mycompanydatabase] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [mycompanydatabase] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [mycompanydatabase] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [mycompanydatabase] SET ARITHABORT OFF 
GO
ALTER DATABASE [mycompanydatabase] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [mycompanydatabase] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [mycompanydatabase] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [mycompanydatabase] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [mycompanydatabase] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [mycompanydatabase] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [mycompanydatabase] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [mycompanydatabase] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [mycompanydatabase] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [mycompanydatabase] SET  DISABLE_BROKER 
GO
ALTER DATABASE [mycompanydatabase] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [mycompanydatabase] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [mycompanydatabase] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [mycompanydatabase] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [mycompanydatabase] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [mycompanydatabase] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [mycompanydatabase] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [mycompanydatabase] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [mycompanydatabase] SET  MULTI_USER 
GO
ALTER DATABASE [mycompanydatabase] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [mycompanydatabase] SET DB_CHAINING OFF 
GO
ALTER DATABASE [mycompanydatabase] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [mycompanydatabase] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [mycompanydatabase] SET DELAYED_DURABILITY = DISABLED 
GO
USE [mycompanydatabase]
GO
/****** Object:  Table [dbo].[countryData]    Script Date: 4/28/2017 11:23:38 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[countryData](
	[countryName] [nvarchar](50) NULL,
	[totalproject] [nvarchar](50) NULL,
	[totalcost] [nvarchar](50) NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[monthlydata]    Script Date: 4/28/2017 11:23:38 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[monthlydata](
	[monthName] [nvarchar](50) NULL,
	[webproject] [nvarchar](50) NULL,
	[mobileproject] [nvarchar](50) NULL,
	[desktopproject] [nvarchar](50) NULL,
	[other] [nvarchar](50) NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[technology]    Script Date: 4/28/2017 11:23:38 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[technology](
	[projecttechnology] [nvarchar](50) NULL,
	[numberofproject] [nvarchar](50) NULL,
	[totalcost] [nvarchar](50) NULL,
	[category] [nvarchar](50) NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[yearlydata]    Script Date: 4/28/2017 11:23:38 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[yearlydata](
	[yearnumber] [nvarchar](50) NULL,
	[totalproject] [nvarchar](50) NULL,
	[totalcost] [nvarchar](50) NULL
) ON [PRIMARY]

GO
USE [master]
GO
ALTER DATABASE [mycompanydatabase] SET  READ_WRITE 
GO
