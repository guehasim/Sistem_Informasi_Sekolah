-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 28, 2014 at 05:24 PM
-- Server version: 5.6.11
-- PHP Version: 5.5.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `sekolah`
--
CREATE DATABASE IF NOT EXISTS `sekolah` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `sekolah`;

-- --------------------------------------------------------

--
-- Table structure for table `aktif_siswa`
--

CREATE TABLE IF NOT EXISTS `aktif_siswa` (
  `tahun_ajaran` varchar(100) DEFAULT NULL,
  `semester` varchar(100) DEFAULT NULL,
  `kelas` varchar(10) DEFAULT NULL,
  `nis` varchar(100) NOT NULL,
  `nama` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `aktif_siswa`
--

INSERT INTO `aktif_siswa` (`tahun_ajaran`, `semester`, `kelas`, `nis`, `nama`) VALUES
('2012/2013', 'Genap', '1', '201210370311117', 'muhammad amin'),
('2013/2014', 'Genap', '1', '201210370311100', 'muhammad akbar');

-- --------------------------------------------------------

--
-- Table structure for table `guru`
--

CREATE TABLE IF NOT EXISTS `guru` (
  `nip` varchar(100) NOT NULL,
  `nama` varchar(100) DEFAULT NULL,
  `tempat` varchar(100) DEFAULT NULL,
  `tgllahir` varchar(100) DEFAULT NULL,
  `jenkel` varchar(100) DEFAULT NULL,
  `agama` varchar(100) DEFAULT NULL,
  `goldarah` varchar(10) DEFAULT NULL,
  `pendidikan` varchar(50) DEFAULT NULL,
  `nama_ortu` varchar(100) DEFAULT NULL,
  `alamat` varchar(100) DEFAULT NULL,
  `desa` varchar(100) DEFAULT NULL,
  `kec` varchar(100) DEFAULT NULL,
  `kota` varchar(100) DEFAULT NULL,
  `propinsi` varchar(100) DEFAULT NULL,
  `foto` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `guru`
--

INSERT INTO `guru` (`nip`, `nama`, `tempat`, `tgllahir`, `jenkel`, `agama`, `goldarah`, `pendidikan`, `nama_ortu`, `alamat`, `desa`, `kec`, `kota`, `propinsi`, `foto`) VALUES
('201210370311109', 'akbar muhammad', 'samarinda', '16-12-1996', 'Laki-Laki', 'Budha', 'AB', 'SD', 'thomas', 'bengkalan', 'oro oro ombo', 'pakisaji', 'bangkalan', 'Jawa Timur', '1.jpg'),
('201210370311108', 'ahmad hasim', 'pasuruan', '13-03-1994', 'Laki-Laki', 'Islam', 'A', 'SD', 'sodikin', 'pasuruan', 'sedarum', 'nguling', 'pasuruan', 'Jawa Timur', 'Foto870.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `kelas`
--

CREATE TABLE IF NOT EXISTS `kelas` (
  `id_kelas` int(11) NOT NULL AUTO_INCREMENT,
  `nama_kelas` varchar(10) NOT NULL,
  PRIMARY KEY (`id_kelas`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `kelas`
--

INSERT INTO `kelas` (`id_kelas`, `nama_kelas`) VALUES
(1, '1'),
(2, '2'),
(3, '3'),
(4, '4'),
(5, '5'),
(6, '6');

-- --------------------------------------------------------

--
-- Table structure for table `kepsek`
--

CREATE TABLE IF NOT EXISTS `kepsek` (
  `id_kepsek` varchar(2) NOT NULL,
  `nip_kepsek` varchar(100) NOT NULL,
  `pass_kepsek` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_kepsek`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kepsek`
--

INSERT INTO `kepsek` (`id_kepsek`, `nip_kepsek`, `pass_kepsek`) VALUES
('1', '201210370311108', '12345');

-- --------------------------------------------------------

--
-- Table structure for table `matpel`
--

CREATE TABLE IF NOT EXISTS `matpel` (
  `kode_matpel` varchar(100) DEFAULT NULL,
  `nama_matpel` varchar(100) DEFAULT NULL,
  `kelas` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `matpel`
--

INSERT INTO `matpel` (`kode_matpel`, `nama_matpel`, `kelas`) VALUES
('108', 'bhs indonesia', '1'),
('115', 'bhs jawa', '1'),
('119', 'bhs inggris', '1'),
('114', 'bhs indonesia', '1'),
('167', 'bhs jawa', '1'),
('321', 'bhs inggris', '1');

-- --------------------------------------------------------

--
-- Table structure for table `nilai`
--

CREATE TABLE IF NOT EXISTS `nilai` (
  `id_nilai` int(255) NOT NULL AUTO_INCREMENT,
  `tahun_ajaran` varchar(100) DEFAULT NULL,
  `semester` varchar(100) DEFAULT NULL,
  `kelas` varchar(10) NOT NULL,
  `nis_siswa` varchar(100) DEFAULT NULL,
  `nama` varchar(100) DEFAULT NULL,
  `pilih_matpel` varchar(100) DEFAULT NULL,
  `nilai` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_nilai`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `nilai`
--

INSERT INTO `nilai` (`id_nilai`, `tahun_ajaran`, `semester`, `kelas`, `nis_siswa`, `nama`, `pilih_matpel`, `nilai`) VALUES
(1, '2013/2014', 'Genap', '1', '201210370311100', 'muhammad akbar', 'bhs indonesia', '61'),
(2, '2012/2013', 'Genap', '1', '201210370311117', 'muhammad amin', 'bhs indonesia', '72');

-- --------------------------------------------------------

--
-- Table structure for table `siswa`
--

CREATE TABLE IF NOT EXISTS `siswa` (
  `nis` varchar(100) NOT NULL,
  `nama` varchar(100) DEFAULT NULL,
  `jenkel` varchar(10) DEFAULT NULL,
  `agama` varchar(100) DEFAULT NULL,
  `tempat` varchar(100) DEFAULT NULL,
  `tgllahir` varchar(100) DEFAULT NULL,
  `alamat` varchar(100) DEFAULT NULL,
  `anakke` varchar(10) DEFAULT NULL,
  `statuskel` varchar(100) DEFAULT NULL,
  `foto` varchar(200) DEFAULT NULL,
  `di_kelas` varchar(10) DEFAULT NULL,
  `tglmasuk` varchar(100) DEFAULT NULL,
  `namasekolah` varchar(100) DEFAULT NULL,
  `alamatsekolah` varchar(100) DEFAULT NULL,
  `ayah` varchar(100) DEFAULT NULL,
  `ibu` varchar(100) DEFAULT NULL,
  `alamatayah` varchar(100) DEFAULT NULL,
  `alamatibu` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `siswa`
--

INSERT INTO `siswa` (`nis`, `nama`, `jenkel`, `agama`, `tempat`, `tgllahir`, `alamat`, `anakke`, `statuskel`, `foto`, `di_kelas`, `tglmasuk`, `namasekolah`, `alamatsekolah`, `ayah`, `ibu`, `alamatayah`, `alamatibu`, `password`) VALUES
('201210370311117', 'muhammad amin', 'Laki-Laki', 'Islam', 'lumajang', '13-12-1995', 'lumajang', '3', 'anak', 'Foto061.jpg', '1', '06-12-2012', 'SDN SUMBERSEKAR 03', 'jln. SumberSekar No.155 Dau', 'sutres', 'siti', 'lumajang', 'lumajang', '12345'),
('201210370311100', 'muhammad akbar', 'Laki-Laki', 'Islam', 'pamekasan', '13-07-1993', 'pamekasan', '2', 'anak', 'IMG_20140112_101245.jpg', '1', '05-12-2012', 'SDN SUMBERSEKAR 03', 'jln. SumberSekar No.155 Dau', 'pi''i', 'neneng', 'madura', 'madura', '12345');

-- --------------------------------------------------------

--
-- Table structure for table `thn_ajar`
--

CREATE TABLE IF NOT EXISTS `thn_ajar` (
  `id_thnajar` int(11) NOT NULL AUTO_INCREMENT,
  `nm_thnajar` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_thnajar`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `thn_ajar`
--

INSERT INTO `thn_ajar` (`id_thnajar`, `nm_thnajar`) VALUES
(1, '2012/2013'),
(4, '2013/2014'),
(5, '2014/2015');

-- --------------------------------------------------------

--
-- Table structure for table `walkes`
--

CREATE TABLE IF NOT EXISTS `walkes` (
  `id_walkes` int(11) NOT NULL AUTO_INCREMENT,
  `nip_walkes` varchar(100) NOT NULL,
  `kelas_walkes` varchar(10) NOT NULL,
  `pass_walkes` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_walkes`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `walkes`
--

INSERT INTO `walkes` (`id_walkes`, `nip_walkes`, `kelas_walkes`, `pass_walkes`) VALUES
(1, '201210370311109', '1', '12345'),
(2, '201210370311104', '2', '12345');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
