-- MySQL dump 10.13  Distrib 5.7.27, for Win64 (x86_64)
--
-- Host: localhost    Database: kviskoteka
-- ------------------------------------------------------
-- Server version	5.7.27-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `anagram`
--

DROP TABLE IF EXISTS `anagram`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `anagram` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `zagonetka` varchar(200) NOT NULL,
  `resenje` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `anagram`
--

LOCK TABLES `anagram` WRITE;
/*!40000 ALTER TABLE `anagram` DISABLE KEYS */;
INSERT INTO `anagram` VALUES (10,'Krasan je odmor','jadransko more'),(11,'Prašak zove','korpa za veš'),(41,'Kad jurcam u nepovrat','karta u jednom pravcu'),(42,'Odeva srećna tela','donatela versaće'),(43,'On sa tla Like','nikola tesla'),(44,'Fin auto','fiat uno');
/*!40000 ALTER TABLE `anagram` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `biljka`
--

DROP TABLE IF EXISTS `biljka`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `biljka` (
  `biljka` varchar(45) NOT NULL,
  PRIMARY KEY (`biljka`),
  UNIQUE KEY `biljka_UNIQUE` (`biljka`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `biljka`
--

LOCK TABLES `biljka` WRITE;
/*!40000 ALTER TABLE `biljka` DISABLE KEYS */;
INSERT INTO `biljka` VALUES ('ananas'),('artičoka'),('avokado'),('bagrem'),('banana'),('brokoli'),('celer'),('čempres'),('čia'),('čičak'),('cvekla'),('dinja'),('dren'),('dud'),('dunja'),('dženarika'),('estragon'),('eukaliptus'),('eva'),('fikus'),('glog'),('grab'),('grožđe'),('heljda'),('hibiskus'),('hmelj'),('hrast'),('iva'),('jabuka'),('jagoda'),('javor'),('jerebika'),('keleraba'),('kelj'),('kivi'),('kruška'),('limun'),('lipa'),('ljiljan'),('ljubičica'),('lubenica'),('malina'),('mango'),('maslina'),('nar'),('narandža'),('nektarina'),('orah'),('papaja'),('paprika'),('paradajz'),('pelin'),('pomorandža'),('repa'),('rotka'),('ruzmarin'),('šargarepa'),('šljiva'),('smokva'),('soja'),('suncokret'),('tikvica'),('trešnja'),('urma'),('vanila'),('višnja'),('vrba'),('žalfija'),('zelje'),('zlatica'),('zova'),('đumbir');
/*!40000 ALTER TABLE `biljka` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `drzava`
--

DROP TABLE IF EXISTS `drzava`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `drzava` (
  `drzava` varchar(45) NOT NULL,
  PRIMARY KEY (`drzava`),
  UNIQUE KEY `drzava_UNIQUE` (`drzava`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drzava`
--

LOCK TABLES `drzava` WRITE;
/*!40000 ALTER TABLE `drzava` DISABLE KEYS */;
INSERT INTO `drzava` VALUES ('albanija'),('alžir'),('andora'),('angola'),('antigva i barbuda'),('argentina'),('australija'),('austrija'),('avganistan'),('azerbejdžan'),('bahama'),('bahrein'),('bangladeš'),('belgija'),('belize'),('belorusija'),('benin'),('bocvana'),('bolivija'),('bosna i hercegovina'),('brazil'),('brunej'),('bugarska'),('burkina faso'),('burundi'),('butan'),('čad'),('česka'),('čile'),('crna gora'),('danska'),('dominika'),('dominikanska republika'),('egipat'),('ekvador'),('ekvatorijalna gvineja'),('engleska'),('eritreja'),('estonija'),('etiopija'),('filipini'),('finska'),('francuska'),('gabon'),('gambija'),('gana'),('grčka'),('grenada'),('gruzija'),('gvajana'),('gvatemala'),('gvineja'),('gvineja bisao'),('haiti'),('holandija'),('honduras'),('hrvatska'),('indija'),('indonezija'),('irak'),('iran'),('irska'),('istočni timor'),('italija'),('izrael'),('jamajka'),('japan'),('jemen'),('jermenija'),('jordan'),('južna afrika'),('južna koreja'),('južni sudan'),('kambodža'),('kamerun'),('kanada'),('katar'),('kazahtsan'),('kenija'),('kina'),('kipar'),('kirgizija'),('kiribati'),('kolumbija'),('komori'),('kongo'),('kostarika'),('kuba'),('kuvajt'),('laos'),('lesoto'),('letonija'),('liban'),('liberija'),('libija'),('lihtenštajn'),('litvanija'),('luksemburg'),('madagaskar'),('makedonija'),('malavi'),('maldivi'),('malezija'),('mali'),('malta'),('maroko'),('mauricijus'),('mauritanija'),('mađarska'),('meksiko'),('mikronezija'),('mjanmar'),('moldavija'),('monako'),('mongolija'),('mozambik'),('namibija'),('nauru'),('nemačka'),('nepal'),('niger'),('nigerija'),('nikaragva'),('norveška'),('novi zeland'),('obala slonovače'),('oman'),('pakistan'),('palau'),('panama'),('papua nova gvineja'),('paragvaj'),('peru'),('poljska'),('portugal'),('portugalija'),('ruanda'),('rumunija'),('rusija'),('sad'),('salvador'),('samoa'),('san marino'),('sao tome i prinsipe'),('saudijska arabija'),('sejšeli'),('senegal'),('sent kits i nevis'),('severna irska'),('severna koreja'),('sijera leone'),('singapur'),('sirija'),('sjedinjene američke države'),('škotska'),('slovačka'),('slovenija'),('solomonska ostrva'),('somalija'),('španija'),('srbija'),('šri lanka'),('sudan'),('surinam'),('švajcarska'),('svazilend'),('švedska'),('sveta lucija'),('sveti vinsent i grenadini'),('tadžikistan'),('tajland'),('tanzanija'),('togo'),('tonga'),('trinidad i tobago'),('tunis'),('turkmenistan'),('turska'),('tuvalu'),('uganda'),('ujedinjeni arapski emirati'),('ujedinjeno kraljevstvo'),('ukrajina'),('urugvaj'),('uzbekistan'),('vanuatu'),('vatikan'),('velika britanija'),('vels'),('venecuela'),('vijetnam'),('zambija'),('zelenortska ostrva'),('zimbabve');
/*!40000 ALTER TABLE `drzava` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grad`
--

DROP TABLE IF EXISTS `grad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grad` (
  `grad` varchar(45) NOT NULL,
  PRIMARY KEY (`grad`),
  UNIQUE KEY `grad_UNIQUE` (`grad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grad`
--

LOCK TABLES `grad` WRITE;
/*!40000 ALTER TABLE `grad` DISABLE KEYS */;
INSERT INTO `grad` VALUES ('abu dabi'),('abudža'),('adis abeba'),('akra'),('alžir'),('aman'),('amsterdam'),('andora'),('andora la velja'),('ankara'),('antananarivo'),('apija'),('ašhabad'),('asmara'),('astana'),('asunsion'),('atina'),('atlanta'),('bagdad'),('baku'),('bamako'),('bandar seri begavan'),('bangi'),('bankok'),('baster'),('beč'),('belmopan'),('beograd'),('berlin'),('bern'),('bisau'),('bogota'),('bor'),('boston'),('bratislava'),('brazavil'),('brazilija'),('brisel'),('budimpešta'),('buenos ajres'),('bukurešt'),('čačak'),('čikago'),('dablin'),('dakar'),('dalas'),('damask'),('dejton'),('denver'),('detroit'),('dodoma'),('doha'),('el paso'),('filadelfija'),('finiks'),('fritaun'),('gabone'),('gitega'),('gvatemala'),('hag'),('hanoj'),('harare'),('havana'),('helsinki'),('hjuston'),('holivud'),('indijanapolis'),('islamabad'),('jagodina'),('jamusukro'),('jaren'),('jaunde'),('jerevan'),('jerusalim'),('kabul'),('kairo'),('kampala'),('kanbera'),('karakas'),('kartum'),('kastri'),('katamandu'),('katmandu'),('kembridž'),('kigali'),('kijev'),('kikinda'),('kingstaun'),('kingston'),('kišinjev'),('kito'),('konakri'),('kopenhagen'),('kragujevac'),('kraljevo'),('kruševac'),('kuala lumpur'),('kuvajt'),('la paz'),('la valeta'),('las vegas'),('leskovac'),('libervil'),('lilongve'),('lima'),('lisabon'),('ljubljana'),('lome'),('london'),('los anđeles'),('loznica'),('luanda'),('luksemburg'),('lusaka'),('majami'),('malabo'),('male'),('managva'),('manama'),('manila'),('maputo'),('mardid'),('maseru'),('maskat'),('mbabane'),('meksiko'),('meksiko siti'),('memfis'),('minhen'),('minsk'),('monako'),('monrovija'),('montevideo'),('montrael'),('moroni'),('moskva'),('najrobi'),('nasau'),('nejpjido'),('nijamej'),('nikozija'),('niš'),('nju delhi'),('nju jork'),('nju orleans'),('njujork'),('novi pazar'),('novi sad'),('nukualofa'),('oslo'),('ostin'),('otava'),('panama'),('pančevo'),('paramaribo'),('pariz'),('peking'),('pirot'),('pjongjang'),('pnom pen'),('podgorica'),('porto novo'),('požarevac'),('požega'),('prag'),('praja'),('pretorija'),('priština'),('prokuplje'),('rabat'),('rejkjavik'),('riga'),('rijad'),('rim'),('rio'),('rio de žaneiro'),('rozo'),('šabac'),('sakramento'),('san antonio'),('san dijego'),('san francisko'),('san hoze'),('san marino'),('san salvador'),('sana'),('santijago'),('santo domingo'),('sao tome'),('sarajevo'),('seul'),('sijetl'),('singapur'),('skopje'),('skoplje'),('smederevo'),('sofija'),('sombor'),('springfild'),('sremska mitrovica'),('stokholm'),('subotica'),('talin'),('taljin'),('tbilisi'),('tegusigalpa'),('teheran'),('timbu'),('tirana'),('tokio'),('toronto'),('tripoli'),('tunis'),('uagadugu'),('ulan bator'),('užice'),('vaduc'),('valeta'),('valjevo'),('vankuver'),('varšava'),('vašington'),('vatikan'),('vijentijan'),('viktorija'),('vilnjus'),('vilnus'),('vindhuk'),('vranje'),('vršac'),('zagreb'),('zakečar'),('zrenjanjin');
/*!40000 ALTER TABLE `grad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `igradana`
--

DROP TABLE IF EXISTS `igradana`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `igradana` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `datum` date NOT NULL,
  `anagram_id` int(11) NOT NULL,
  `pehar_id` int(11) NOT NULL,
  `vesanje_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `datum_UNIQUE` (`datum`),
  KEY `anagram_id` (`anagram_id`),
  KEY `pehar_id` (`pehar_id`),
  KEY `vesanje_id` (`vesanje_id`),
  CONSTRAINT `igradana_ibfk_1` FOREIGN KEY (`anagram_id`) REFERENCES `anagram` (`id`),
  CONSTRAINT `igradana_ibfk_2` FOREIGN KEY (`pehar_id`) REFERENCES `pehar` (`id`),
  CONSTRAINT `igradana_ibfk_3` FOREIGN KEY (`vesanje_id`) REFERENCES `vesanje` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `igradana`
--

LOCK TABLES `igradana` WRITE;
/*!40000 ALTER TABLE `igradana` DISABLE KEYS */;
INSERT INTO `igradana` VALUES (21,'2019-08-28',11,12,2),(22,'2019-08-29',11,12,4),(23,'2019-08-30',10,17,4),(24,'2019-09-05',11,12,1),(25,'2019-09-11',10,12,4),(26,'2019-08-31',43,17,32),(27,'2019-09-01',11,17,1);
/*!40000 ALTER TABLE `igradana` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jezero`
--

DROP TABLE IF EXISTS `jezero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jezero` (
  `jezero` varchar(45) NOT NULL,
  PRIMARY KEY (`jezero`),
  UNIQUE KEY `jezero_UNIQUE` (`jezero`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jezero`
--

LOCK TABLES `jezero` WRITE;
/*!40000 ALTER TABLE `jezero` DISABLE KEYS */;
INSERT INTO `jezero` VALUES ('albertovo'),('aralsko'),('atabaska'),('bajkalsko'),('belo'),('borsko'),('dongting'),('ejr'),('gazivode'),('hanka'),('hjuron'),('iri'),('isik kul'),('jezero irvasa'),('kaspijsko'),('ladora'),('manitoba'),('marakaibo'),('mičigen'),('mveru'),('netling'),('nikaragva'),('nipigon'),('onego'),('onjega'),('ontario'),('palić'),('palićko'),('perućačko'),('potpećko'),('srebrno'),('šumsko'),('tanganjika'),('tonle sap'),('torens'),('turkana'),('urmija'),('veliko medveđe'),('veliko ropsko'),('veliko slano'),('venern'),('viktorijino'),('vinipeg'),('vinipegosis'),('vlasinsko'),('vostok'),('zlatarsko'),('zlatiborsko'),('đeravica'),('đerdap'),('đerdapsko');
/*!40000 ALTER TABLE `jezero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `muzickagrupa`
--

DROP TABLE IF EXISTS `muzickagrupa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `muzickagrupa` (
  `muzickagrupa` varchar(45) NOT NULL,
  PRIMARY KEY (`muzickagrupa`),
  UNIQUE KEY `muzickagrupa_UNIQUE` (`muzickagrupa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `muzickagrupa`
--

LOCK TABLES `muzickagrupa` WRITE;
/*!40000 ALTER TABLE `muzickagrupa` DISABLE KEYS */;
INSERT INTO `muzickagrupa` VALUES ('aba'),('abba'),('ac dc'),('aerosmit'),('babe'),('bajaga i instruktori'),('beatles'),('bijelo dugme'),('bitlsi'),('coldplay'),('crvena jabuka'),('ekatarina velika'),('ekv'),('elektricni orgazam'),('galija'),('generacija 5'),('generacija pet'),('koldplej'),('kvin'),('maroon 5'),('marun 5'),('metalika'),('mobi dik'),('negativ'),('neverne bebe'),('prljavo kazaliste'),('riblja čorba'),('tap 011'),('van gog');
/*!40000 ALTER TABLE `muzickagrupa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pehar`
--

DROP TABLE IF EXISTS `pehar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pehar` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pitanje1` varchar(200) NOT NULL,
  `odgovor1` varchar(20) NOT NULL,
  `pitanje2` varchar(200) NOT NULL,
  `odgovor2` varchar(20) NOT NULL,
  `pitanje3` varchar(200) NOT NULL,
  `odgovor3` varchar(20) NOT NULL,
  `pitanje4` varchar(200) NOT NULL,
  `odgovor4` varchar(20) NOT NULL,
  `pitanje5` varchar(200) NOT NULL,
  `odgovor5` varchar(20) NOT NULL,
  `pitanje6` varchar(200) NOT NULL,
  `odgovor6` varchar(20) NOT NULL,
  `pitanje7` varchar(200) NOT NULL,
  `odgovor7` varchar(20) NOT NULL,
  `pitanje8` varchar(200) NOT NULL,
  `odgovor8` varchar(20) NOT NULL,
  `pitanje9` varchar(200) NOT NULL,
  `odgovor9` varchar(20) NOT NULL,
  `pitanje10` varchar(200) NOT NULL,
  `odgovor10` varchar(20) NOT NULL,
  `pitanje11` varchar(200) NOT NULL,
  `odgovor11` varchar(20) NOT NULL,
  `pitanje12` varchar(200) NOT NULL,
  `odgovor12` varchar(20) NOT NULL,
  `pitanje13` varchar(200) NOT NULL,
  `odgovor13` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pehar`
--

LOCK TABLES `pehar` WRITE;
/*!40000 ALTER TABLE `pehar` DISABLE KEYS */;
INSERT INTO `pehar` VALUES (12,'Muzički instrument sa klavijaturom ili dugmadima','harmonika','Testenina u obliku tube','makaroni','Skraćenica od početnih slova ili slogova','akronim','Deo nameštaja za držanje garderobe (množina)','ormani','Način života, rada, postupaka, ponašanja','manir','Glasovno podudaranje slogova na kraju stihova','rima','Okvir za sliku','ram','Zglob koji povezuje ruku i trup','rame','Osećanje uzbuđenja ili straha','trema','Sinonim za majku','matera','Onaj koji se bavi nečim iz ljubavi, a ne iz finansijske koristi (množina)','amateri','Supstancija od koje su sačinjeni fizički objekti','materija','Čvrsta materija koja ima masu i zauzima prostor','materijal'),(17,'Vrsta breskve, glatka po površini','nektarina','Lokacija za izdvajanje zaraženih osoba u cilju sprečavanja epidemije','karantin','Tekstilni proizvod od sitnih vlakana','tkanina','Period istorije u kom su vodeću ulogu imale stara Grčka i Rim','antika','Ukrasni predmeti, kao na primer prstenje, minđuše itd','nakit','Država u istočnoj Aziji','kina','Grad u Francuskoj poznat poznat po filmskom festivalu','kan','Grčka boginja pobede','nika','Slika svetitelja','ikona','Meteorološka pojava brzih vetrova i mnogo kiše (množina)','orkani','Sinonim za šifrovan','kodiran','Sistem učenja, u istoriji poznata Monroova','doktrina','Pokazatelj stanja neke pojave','indikator');
/*!40000 ALTER TABLE `pehar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `planina`
--

DROP TABLE IF EXISTS `planina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `planina` (
  `planina` varchar(45) NOT NULL,
  PRIMARY KEY (`planina`),
  UNIQUE KEY `planina_UNIQUE` (`planina`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `planina`
--

LOCK TABLES `planina` WRITE;
/*!40000 ALTER TABLE `planina` DISABLE KEYS */;
INSERT INTO `planina` VALUES ('ararat'),('atos'),('avala'),('beljanica'),('bjelašnica'),('bjelolasica'),('čemernik'),('čemerno'),('cer'),('cincar'),('crni vrh'),('crvanj'),('dimitor'),('dinara'),('dinarske planine'),('dukat'),('durmitor'),('dželska'),('elgon'),('fruška gora'),('fudži'),('goč'),('golak'),('golija'),('grmeč'),('hajla'),('hrgud'),('hum'),('ida'),('igman'),('ivan'),('ivan planina'),('jagodnja'),('jahorina'),('jastrebac'),('jelica'),('juhor'),('kopaonik'),('kosmaj'),('kozara'),('kukavica'),('leotar'),('ljubić'),('lovćen'),('maljen'),('nenos'),('ninaja'),('olimp'),('orjen'),('ozren'),('pobijenik'),('povlen'),('radan'),('rogozna'),('rtanj'),('rujen'),('šar'),('šar planina'),('stara'),('stara planina'),('stolovi'),('suva'),('suva planina'),('tara'),('tavor'),('tresibaba'),('uzolomac'),('vitorog'),('vodno'),('zelengora'),('zlatar'),('zlatibor'),('žljeb'),('đedinska');
/*!40000 ALTER TABLE `planina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reka`
--

DROP TABLE IF EXISTS `reka`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reka` (
  `reka` varchar(45) NOT NULL,
  PRIMARY KEY (`reka`),
  UNIQUE KEY `reka_UNIQUE` (`reka`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reka`
--

LOCK TABLES `reka` WRITE;
/*!40000 ALTER TABLE `reka` DISABLE KEYS */;
INSERT INTO `reka` VALUES ('adra'),('adrov'),('amazon'),('amur'),('begej'),('beli drim'),('beli timok'),('bodva'),('bojana'),('bosna'),('bru'),('ćehotina'),('čemernica'),('cernica'),('cetina'),('čik'),('čikola'),('crni drim'),('crni timok'),('crnica'),('dadu'),('drava'),('drim'),('drina'),('dunav'),('ebro'),('erenik'),('eurota'),('evel'),('fulda'),('gang'),('glina'),('gradinac'),('grza'),('hadson'),('hoangho'),('ibar'),('ilova'),('ind'),('jadar'),('jadova'),('jadro'),('jordan'),('južna morava'),('kolubara'),('kongo'),('krka'),('krupa'),('lepenica'),('lika'),('lim'),('ljig'),('ljubljanica'),('lonja'),('mekong'),('misisipi'),('mlava'),('morava'),('nera'),('neretva'),('nerodinka'),('njasluha'),('njemen'),('ob'),('odra'),('ohajo'),('orinoko'),('pčinja'),('pek'),('piva'),('plitvica'),('rzav'),('sava'),('šepda'),('špreja'),('štira'),('tamiš'),('tara'),('temza'),('tigar'),('timok'),('tisa'),('ub'),('una'),('uvac'),('velika morava'),('veternica'),('visla'),('vista'),('volga'),('zambezi'),('zapadna morava'),('ždralica'),('zeta'),('zlatica'),('zmrnja'),('đetinja');
/*!40000 ALTER TABLE `reka` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rezultati`
--

DROP TABLE IF EXISTS `rezultati`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rezultati` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `datum` date NOT NULL,
  `username` varchar(200) NOT NULL,
  `poeni` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `username` (`username`),
  CONSTRAINT `rezultati_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rezultati`
--

LOCK TABLES `rezultati` WRITE;
/*!40000 ALTER TABLE `rezultati` DISABLE KEYS */;
INSERT INTO `rezultati` VALUES (41,'2019-08-28','carica',58),(42,'2019-08-28','koala',60),(43,'2019-08-28','gago',67),(44,'2019-08-29','koala',49),(47,'2019-08-29','gago',32),(48,'2019-08-29','carica',54),(49,'2019-08-29','zaklina',65),(50,'2019-08-29','ana',42),(51,'2019-08-29','goran',52),(52,'2019-08-29','mico',32),(53,'2019-08-30','korisnik',40),(54,'2019-08-30','koala',45),(55,'2019-08-30','gago',88),(56,'2019-08-30','carica',42),(58,'2019-08-30','zaklina',30),(59,'2019-08-02','koala',45),(60,'2019-07-25','koala',48),(61,'2019-07-13','koala',115),(62,'2019-08-05','goran',74),(63,'2019-08-05','mico',120),(64,'2019-08-05','zaklina',100),(65,'2019-08-07','user123',51),(66,'2019-08-08','user123',13),(67,'2019-08-05','pera',50),(68,'2019-08-05','pera',280),(70,'2019-08-30','mico',48),(71,'2019-08-30','pera',40),(72,'2019-08-30','anchy',49),(73,'2019-08-30','koala1',87),(74,'2019-08-30','ana',46),(75,'2019-08-30','user123',74),(76,'2019-08-30','goran',12),(77,'2019-08-30','pereca',2),(78,'2019-08-31','jagoda',20),(80,'2019-08-31','koala',10),(82,'2019-08-31','gago',10),(83,'2019-08-31','carica',15),(84,'2019-08-31','koala1',10),(85,'2019-08-31','user123',20),(86,'2019-08-31','goran',15),(87,'2019-08-31','zaklina',30),(88,'2019-08-31','anchy',20),(89,'2019-08-31','pera',10),(90,'2019-08-31','pereca',26),(91,'2019-08-31','takmicar',10),(92,'2019-08-31','etfovac',10),(94,'2019-08-31','ananas',48),(95,'2019-08-31','mico',24),(99,'2019-08-31','devetar',0),(100,'2019-08-31','pilcou',44);
/*!40000 ALTER TABLE `rezultati` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password_hash` varchar(64) NOT NULL,
  `tajnopitanje` varchar(200) NOT NULL,
  `odgovor_hash` varchar(64) NOT NULL,
  `ime` varchar(45) NOT NULL,
  `prezime` varchar(45) NOT NULL,
  `jmbg` varchar(13) NOT NULL,
  `email` varchar(45) NOT NULL,
  `zanimanje` varchar(45) NOT NULL,
  `pol` varchar(45) NOT NULL,
  `tip` varchar(45) NOT NULL,
  `profilna` blob,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','f4035833cb911a3e8634903e498ff84b05d4b66f73c6155af3f58b22ad3503f4','Koja je Vaša omiljena životinja?','6aaad967135aafdc7b2379ab8950a767fd499038cc080801720f23151234c764','Admin','Admin','0101990410150','admin@gmail.com','admin','muski','admin',''),(2,'ana','f4035833cb911a3e8634903e498ff84b05d4b66f73c6155af3f58b22ad3503f4','Koja je Vaša omiljena životinja?','6aaad967135aafdc7b2379ab8950a767fd499038cc080801720f23151234c764','Ana','Stakic','2609997715138','anastakic26@gmail.com','student','zenski','takmicar',''),(3,'koala','54b61e34b4979e4b78566ca357cbaf6b2f8fec9d224ac073dfc4e12d968a495a','Koja je Vaša omiljena životinja?','6aaad967135aafdc7b2379ab8950a767fd499038cc080801720f23151234c764','Ana','Stakic','2609997715138','anastakic26@gmail.com','student','zenski','takmicar',''),(4,'gago','54b61e34b4979e4b78566ca357cbaf6b2f8fec9d224ac073dfc4e12d968a495a','Koje je Vaše omiljeno jelo?','f7176269a0478f8a89a08edffa9077f9a42072a5f769c7816872aece2532f448','Dragan','Stakic','3005018100100','draganstakic@gmail.com','macka','muski','takmicar',''),(5,'mico','54b61e34b4979e4b78566ca357cbaf6b2f8fec9d224ac073dfc4e12d968a495a','Kako se zove Vaše učiteljica?','a4114b0c0d92f2e52253e25e666024bb84b6e2a7ca74bad3dc743f374001e526','Milica','Stakic','0212999715144','micastakic@gmail.com','student','zenski','takmicar',''),(6,'pera','54b61e34b4979e4b78566ca357cbaf6b2f8fec9d224ac073dfc4e12d968a495a','Koja je Vaša omiljena životinja?','6aaad967135aafdc7b2379ab8950a767fd499038cc080801720f23151234c764','Pera','Peric','1234567890123','pera@gmail.com','policajac','muski','takmicar',''),(7,'anchy','54b61e34b4979e4b78566ca357cbaf6b2f8fec9d224ac073dfc4e12d968a495a','Koja je Vaša omiljena životinja?','6aaad967135aafdc7b2379ab8950a767fd499038cc080801720f23151234c764','Ana','Stakic','2609997715138','anastakic26@gmail.com','student','zenski','takmicar',''),(9,'koala1','54b61e34b4979e4b78566ca357cbaf6b2f8fec9d224ac073dfc4e12d968a495a','Koja je Vaša omiljena životinja?','6aaad967135aafdc7b2379ab8950a767fd499038cc080801720f23151234c764','Ana','Stakic','2609997715138','anastakic26@gmail.com','student','zenski','takmicar',''),(10,'carica','54b61e34b4979e4b78566ca357cbaf6b2f8fec9d224ac073dfc4e12d968a495a','Koja je Vaša omiljena društvena mreža?','5ede56738376a8c53a7c99bf275b077a5c10df780a20cf3d8282fd59a2a9fb56','Carica','Caric','0212999715144','car@gmail.com','car','zenski','takmicar',''),(11,'user123','54b61e34b4979e4b78566ca357cbaf6b2f8fec9d224ac073dfc4e12d968a495a','Koja je Vaša omiljena životinja?','6aaad967135aafdc7b2379ab8950a767fd499038cc080801720f23151234c764','Pero','fsfvssf','2609997715138','anastakic26@gmail.com','student','zenski','takmicar',''),(12,'korisnik','54b61e34b4979e4b78566ca357cbaf6b2f8fec9d224ac073dfc4e12d968a495a','Koja je Vaša omiljena životinja?','6aaad967135aafdc7b2379ab8950a767fd499038cc080801720f23151234c764','Laza','Lazic','1234567890123','laza@gmail.com','pekar','muski','takmicar',''),(13,'zaklina','54b61e34b4979e4b78566ca357cbaf6b2f8fec9d224ac073dfc4e12d968a495a','Koja je Vaša omiljena boja?','f9125e51c6a92fe07d18c94642766c95926fb3fe0fa8deda1a436212a653518e','Mira','Stakic','2509966715178','mirastakic@gmail.com','student','zenski','takmicar',''),(14,'supervizor','54b61e34b4979e4b78566ca357cbaf6b2f8fec9d224ac073dfc4e12d968a495a','Koja je Vaša omiljena životinja?','6aaad967135aafdc7b2379ab8950a767fd499038cc080801720f23151234c764','Petar','Pan','1505995348651','petarpan@gmail.com','supervizor','muski','supervizor',''),(15,'goran','54b61e34b4979e4b78566ca357cbaf6b2f8fec9d224ac073dfc4e12d968a495a','Koja je Vaša omiljena životinja?','6aaad967135aafdc7b2379ab8950a767fd499038cc080801720f23151234c764','Goran','Stakic','0103965710071','stagorarh@gmail.com','arhitekta','muski','takmicar',''),(16,'takmicar','54b61e34b4979e4b78566ca357cbaf6b2f8fec9d224ac073dfc4e12d968a495a','Koja je Vaša omiljena životinja?','6aaad967135aafdc7b2379ab8950a767fd499038cc080801720f23151234c764','Zika','Zikic','1234567890123','anastakic26@gmail.com','student','muski','takmicar',''),(17,'pereca','54b61e34b4979e4b78566ca357cbaf6b2f8fec9d224ac073dfc4e12d968a495a','Koja je Vaša omiljena životinja?','6aaad967135aafdc7b2379ab8950a767fd499038cc080801720f23151234c764','Pereca','Perecic','1234567890123','anastakic26@gmail.com','pecivo','muski','takmicar',''),(18,'jagoda','54b61e34b4979e4b78566ca357cbaf6b2f8fec9d224ac073dfc4e12d968a495a','Koja je Vaša omiljena životinja?','6aaad967135aafdc7b2379ab8950a767fd499038cc080801720f23151234c764','Jagoda','Jagodic','2609997715138','anastakic26@gmail.com','student','zenski','takmicar',NULL),(19,'etfovac','54b61e34b4979e4b78566ca357cbaf6b2f8fec9d224ac073dfc4e12d968a495a','Koja je Vaša omiljena životinja?','6aaad967135aafdc7b2379ab8950a767fd499038cc080801720f23151234c764','Ana','Stakic','2609997715138','anastakic26@gmail.com','student','zenski','takmicar',NULL),(20,'devetar','54b61e34b4979e4b78566ca357cbaf6b2f8fec9d224ac073dfc4e12d968a495a','Koja je Vaša omiljena životinja?','6aaad967135aafdc7b2379ab8950a767fd499038cc080801720f23151234c764','Ana','Stakic','0212999715144','anastakic26@gmail.com','student','zenski','takmicar',NULL),(21,'ananas','54b61e34b4979e4b78566ca357cbaf6b2f8fec9d224ac073dfc4e12d968a495a','Koja je Vaša omiljena životinja?','6aaad967135aafdc7b2379ab8950a767fd499038cc080801720f23151234c764','Ana','Stakic','1234567890123','adminadmin@gmail.com','student','zenski','takmicar',NULL),(22,'lubenica','54b61e34b4979e4b78566ca357cbaf6b2f8fec9d224ac073dfc4e12d968a495a','Koja je Vaša omiljena životinja?','6aaad967135aafdc7b2379ab8950a767fd499038cc080801720f23151234c764','Ana','Stakic','1234567890123','anastakic26@gmail.com','student','zenski','takmicar',NULL),(23,'pilcou','54b61e34b4979e4b78566ca357cbaf6b2f8fec9d224ac073dfc4e12d968a495a','Koje je Vaše omiljeno jelo?','95f99182f3b3764b6395f9a2d8ec41c913f96ade7292d349bcbda4913a1b055a','marko','kujundzic','0807997710054','draganstakic@gmail.com','student','muski','takmicar',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vesanje`
--

DROP TABLE IF EXISTS `vesanje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vesanje` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rec` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vesanje`
--

LOCK TABLES `vesanje` WRITE;
/*!40000 ALTER TABLE `vesanje` DISABLE KEYS */;
INSERT INTO `vesanje` VALUES (1,'suncokret'),(2,'mikroskop'),(3,'trepavica'),(4,'hemisfera'),(5,'pozornica'),(6,'mirođija'),(32,'čitaonica'),(35,'mandarina');
/*!40000 ALTER TABLE `vesanje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zivotinja`
--

DROP TABLE IF EXISTS `zivotinja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zivotinja` (
  `zivotinja` varchar(45) NOT NULL,
  PRIMARY KEY (`zivotinja`),
  UNIQUE KEY `zivotinja_UNIQUE` (`zivotinja`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zivotinja`
--

LOCK TABLES `zivotinja` WRITE;
/*!40000 ALTER TABLE `zivotinja` DISABLE KEYS */;
INSERT INTO `zivotinja` VALUES ('ajkula'),('albatros'),('antilopa'),('ara'),('babun'),('bivo'),('bizon'),('boa'),('čaplja'),('čavka'),('činčila'),('ćurka'),('cvrčak'),('dabar'),('detlić'),('deverika'),('eja'),('emu'),('flamingo'),('foka'),('fugu'),('galeb'),('gavran'),('grgeč'),('haringa'),('hijena'),('hrčak'),('ibis'),('irvas'),('iverak'),('jazavac'),('jegulja'),('jež'),('kolibri'),('kuna'),('lasta'),('lav'),('lemur'),('ljiljak'),('losos'),('mačka'),('majmun'),('medved'),('miš'),('njorka'),('noj'),('nosorog'),('okapi'),('orao'),('panda'),('pauk'),('prepelica'),('puma'),('rak'),('ris'),('roda'),('šaran'),('ševa'),('soko'),('som'),('sova'),('štuka'),('tetreb'),('tigar'),('tuna'),('tvor'),('valabi'),('veverica'),('vrana'),('ždral'),('zebra'),('zec');
/*!40000 ALTER TABLE `zivotinja` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'kviskoteka'
--

--
-- Dumping routines for database 'kviskoteka'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-08-31 12:11:18
