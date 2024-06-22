# Import Excel To Database

"Import Excel to Database" adalah sebuah aplikasi yang dirancang untuk membantu pengembang dalam mengimpor data dari file Excel ke dalam database secara efisien dan mudah. Alat ini sangat berguna untuk berbagai keperluan seperti migrasi data, pembaruan data secara massal, dan integrasi data dari berbagai sumber.

## Prasyarat

Pastikan Anda telah menginstal software berikut:

- [Java JDK 11 atau lebih tinggi](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Apache Maven 3.6.3 atau lebih tinggi](https://maven.apache.org/download.cgi)

## Instalasi

Langkah-langkah untuk menginstal proyek ini di mesin lokal Anda.

1. Clone repository:

    ```bash
    git clone https://github.com/marijmokoginta/import-excel-to-database-cli.git
    cd import-excel-to-database-cli
    ```

2. Bangun proyek dan instal dependensi:

    ```bash
    mvn clean install
    ```

## Menjalankan Aplikasi

Berikut adalah perintah untuk menjalankan aplikasi ini.
    ```bash
    mvn exec:java -Dexec.mainClass=com.marijmokoginta.excel_to_database.ImportExcelProjectApplication
    ```
