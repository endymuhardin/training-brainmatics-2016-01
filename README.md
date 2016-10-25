# training-brainmatics-2016-01

## Setup Database Aplikasi Pelatihan ##

1. Login ke MySQL

        mysql -u root

2. Create username dan password untuk connect ke database

        grant all on pelatihan.* to pelatihan@localhost identified by '1234';

3. Create database

        create database pelatihan;

4. Logout sebagai user root

        \q

5. Login sebagai user pelatihan

        mysql -u pelatihan -p
        Enter password:1234[Enter]

6. Pilih database

        use pelatihan;
