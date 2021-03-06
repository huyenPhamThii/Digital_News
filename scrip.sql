USE [master]
GO
/****** Object:  Database [DigitalNews]    Script Date: 5/16/2021 9:47:22 AM ******/
CREATE DATABASE [DigitalNews]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'DigitalNews', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\DigitalNews.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'DigitalNews_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\DigitalNews_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [DigitalNews] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [DigitalNews].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [DigitalNews] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [DigitalNews] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [DigitalNews] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [DigitalNews] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [DigitalNews] SET ARITHABORT OFF 
GO
ALTER DATABASE [DigitalNews] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [DigitalNews] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [DigitalNews] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [DigitalNews] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [DigitalNews] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [DigitalNews] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [DigitalNews] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [DigitalNews] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [DigitalNews] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [DigitalNews] SET  ENABLE_BROKER 
GO
ALTER DATABASE [DigitalNews] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [DigitalNews] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [DigitalNews] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [DigitalNews] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [DigitalNews] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [DigitalNews] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [DigitalNews] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [DigitalNews] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [DigitalNews] SET  MULTI_USER 
GO
ALTER DATABASE [DigitalNews] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [DigitalNews] SET DB_CHAINING OFF 
GO
ALTER DATABASE [DigitalNews] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [DigitalNews] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [DigitalNews] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [DigitalNews] SET QUERY_STORE = OFF
GO
USE [DigitalNews]
GO
/****** Object:  Table [dbo].[article]    Script Date: 5/16/2021 9:47:22 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[article](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[title] [nvarchar](50) NOT NULL,
	[description] [nvarchar](max) NOT NULL,
	[image] [nvarchar](50) NOT NULL,
	[author] [nvarchar](50) NOT NULL,
	[timePost] [datetime] NOT NULL,
	[shortDes] [nvarchar](max) NOT NULL,
 CONSTRAINT [PK_article] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[article] ON 

INSERT [dbo].[article] ([id], [title], [description], [image], [author], [timePost], [shortDes]) VALUES (1, N'Men and their career', N'Non-traditional careers for men are those which are, traditionally, performed by women. Women have historically been perceived as more nurturing than men, and as a result female-dominated careers often require a significant amount of empathy (for example, fields such as teaching and nursing). Luckily these stereotypes don’t reflect the reality that men are also entirely capable of enjoying and succeeding in non-traditional careers. Continue reading to learn more about what careers are female dominated and why men should consider joining these growing fields.. Non-traditional careers for men are those which are, traditionally, performed by women. Women have historically been perceived as more nurturing than men, and as a result female-dominated careers often require a significant amount of empathy (for example, fields such as teaching and nursing). Luckily these stereotypes don’t reflect the reality that men are also entirely capable of enjoying and succeeding in non-traditional careers. Continue reading to learn more about what careers are female dominated and why men should consider joining these growing fields.', N'i1.jpg', N'Saniea', CAST(N'2021-05-14T09:53:13.140' AS DateTime), N'The United States Department of Labor officially defines a non-traditional career as one in which the opposite gender holds 75% or more of the positions in that occupation. In this case, that means jobs with 25% or less male employees. Here are some traditionally female-dominated careers that are expected to grow through 2026.')
INSERT [dbo].[article] ([id], [title], [description], [image], [author], [timePost], [shortDes]) VALUES (2, N'What is haapiness', N'Happiness is an emotional state characterized by feelings of joy, satisfaction, contentment, and fulfillment. While happiness has many different definitions, it is often described as involving positive emotions and life satisfaction. 

When most people talk about happiness, they might be talking about how they feel in the present moment, or they might be referring to a more general sense of how they feel about life overall.

Because happiness tends to be such a broadly defined term, psychologists and other social scientists typically use the term ''subjective well-being'' when they talk about this emotional state. Just as it sounds, subjective well-being tends to focus on an individual''s overall personal feelings about their life in the present.  ', N'i1.jpg', N'Creana Daviena', CAST(N'2021-05-14T09:54:36.010' AS DateTime), N'The balance of emotions: Everyone experiences both positive and negative emotions, feelings, and moods. Happiness is generally linked to experiencing more positive feelings than negative.')
INSERT [dbo].[article] ([id], [title], [description], [image], [author], [timePost], [shortDes]) VALUES (3, N'Why the study is important', N'Happy people still feel the whole range of human emotions—anger, frustrastion, boredom, loneliness, and even sadness—from time to time. But even when faced with discomfort, they have an underlying sense of optimism that things will get better, that they can deal with what is happening, and that they will be able to feel happy again.. Happy people still feel the whole range of human emotions—anger, frustrastion, boredom, loneliness, and even sadness—from time to time. But even when faced with discomfort, they have an underlying sense of optimism that things will get better, that they can deal with what is happening, and that they will be able to feel happy again.', N'i1.jpg', N'Julia Manena', CAST(N'2021-05-14T09:55:38.090' AS DateTime), N'There are many different ways of thinking about happiness. For example, the ancient Greek philosopher Aristotle made a distinction between two different kinds of happiness: hedonia and eudaimonia.')
INSERT [dbo].[article] ([id], [title], [description], [image], [author], [timePost], [shortDes]) VALUES (4, N'Which is the happiness country', N'Hedonia and eudemonia are more commonly known today in psychology as pleasure and meaning, respectively. More recently, psychologists have suggested the addition of the third component that relates to engagement. These are feelings of commitment and participation in different areas of life.

Research suggests that happy people tend to rank pretty high on eudaimonic life satisfaction and better than average on their hedonic life satisfaction.1﻿ 

All of these can play an important role in the overall experience of happiness, although the relative value of each can be highly subjective. Some activities may be both pleasurable and meaningful, while others might skew more one way or the other.

For example, volunteering for a cause you believe in might be more meaningful than pleasurable. Watching your favorite tv show, on the other hand, might rank lower in meaning and higher on pleasure.', N'i1.jpg', N'Mana Anna', CAST(N'2021-05-14T09:56:56.223' AS DateTime), N'Studies have found that people tend to over earn—they become so focused on accumulating things that they lose track of actually enjoying what they are doing.')
INSERT [dbo].[article] ([id], [title], [description], [image], [author], [timePost], [shortDes]) VALUES (8, N'Men and their career', N'Positive feelings increase resilience. Resilience helps people better manage stress and bounce back better when faced with setbacks. For example, one study found that happier people tend to have lower levels of the stress hormone cortisol and that these benefits tend to persist over time.', N'i1.jpg', N'Romeo', CAST(N'2021-05-14T09:58:09.503' AS DateTime), N'Being happy may make help you get sick less often. Happier mental states are linked to increased immunity.')
INSERT [dbo].[article] ([id], [title], [description], [image], [author], [timePost], [shortDes]) VALUES (9, N'Improving Your Happiness', N'Some people seem to have a naturally higher baseline for happiness—one large-scale study of more than 2,000 twins suggested that around 50% of overall life satisfaction was due to genetics, 10% to external events, and 40% to individual activities.9﻿

So while you might not be able to control what your “base level” of happiness is, there are things that you can do to make your life happier and more fulfilling. Even the happiest of individuals can feel down from time to time and happiness is something that all people need to consciously pursue.', N'i1.jpg', N'Julia', CAST(N'2021-05-14T09:58:35.727' AS DateTime), N'Even a little bit of exercise produces a happiness boost—people who were physically active for as little as 10 minutes a day or who worked out only once a week had higher levels of happiness than people who never exercised.')
INSERT [dbo].[article] ([id], [title], [description], [image], [author], [timePost], [shortDes]) VALUES (11, N'When we finally have ending', N'Most of us probably don’t believe we need a formal definition of happiness; we know it when we feel it, and we often use the term to describe a range of positive emotions, including joy, pride, contentment, and gratitude.

But to understand the causes and effects of happiness, researchers first need to define it. Many of them use the term interchangeably with “subjective well-being,” which they measure by simply asking people to report how satisfied they feel with their own lives and how much positive and negative emotion they’re experiencing. In her 2007 book The How of Happiness, positive psychology researcher Sonja Lyubomirsky elaborates, describing happiness as “the experience of joy, contentment, or positive well-being, combined with a sense that one’s life is good, meaningful, and worthwhile.”

That definition resonates with us here at Greater Good: It captures the fleeting positive emotions that come with happiness, along with a deeper sense of meaning and purpose in life—and suggests how these emotions and sense of meaning reinforce one another.

', N'i1.jpg', N'Anna Stala', CAST(N'2021-05-15T08:32:49.020' AS DateTime), N'Most of us probably don’t believe we need a formal definition of happiness; we know it when we feel it, and we often use the term to describe a range of positive emotions, including joy, pride, contentment, and gratitude.')
INSERT [dbo].[article] ([id], [title], [description], [image], [author], [timePost], [shortDes]) VALUES (12, N'How can we find our own happiness', N'And speaking of the literature, you will find references to SWB everywhere. A quick Google search for the word “happiness” offers over 2 million results (as of January 6th, 2019). Further, a scan for the same term in two of psychology’s biggest online databases (PsycINFO and PsycARTICLES) returns 19,139 results from academic and other journals, books, dissertations, and more.. And speaking of the literature, you will find references to SWB everywhere. A quick Google search for the word “happiness” offers over 2 million results (as of January 6th, 2019). Further, a scan for the same term in two of psychology’s biggest online databases (PsycINFO and PsycARTICLES) returns 19,139 results from academic and other journals, books, dissertations, and more.', N'i1.jpg', N'White Dasne', CAST(N'2021-05-15T08:35:09.123' AS DateTime), N'First, let’s take a look at the definition of happiness so we’re all on the same page. Oxford English Dictionary’s definition of “happiness” is a simple one: “The state of being happy.”')
SET IDENTITY_INSERT [dbo].[article] OFF
GO
ALTER TABLE [dbo].[article] ADD  CONSTRAINT [DF_article_timePost]  DEFAULT (getdate()) FOR [timePost]
GO
USE [master]
GO
ALTER DATABASE [DigitalNews] SET  READ_WRITE 
GO

SELECT TOP 6 * FROM article ORDER BY timePost DESC

SELECT COUNT(*) FROM article
WHERE title LIKE '%%'

SELECT * FROM article

SELECT * FROM article 
WHERE title LIKE '%%'
ORDER BY id
OFFSET 0 ROWS FETCH NEXT 3 ROWS ONLY 
