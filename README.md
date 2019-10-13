## Java

* JDK 11.0.2 General-Availability Release https://jdk.java.net/11/
* Windows / x64 direct https://download.java.net/java/GA/jdk11/9/GPL/openjdk-11.0.2_windows-x64_bin.zip

## IDE

* Formatter \ticket-booking-demo\src\main\resources\formatter.xml

## Build and run

* mvn spring-boot:run

* Skrypt z końcówkami znajduje się w katalogu /demo-script. Wchodzimy do katalogu i wpisujemy w konsoli ./demo_script.sh 

## Sub Case

* Dodawany jest nowe audytorium
* Dodawany jest nowy filmu
* Dodawany jest nowy seans

 ## Main Case
 
* Wyszukuje wszystkie filmy w podanym okresie czasowym (w tym dodany seans)
* Informacje o wybranym seansie
* Próba dokonania rezerwacji bez wybranego miejsca
* Poprawna rezerwacja (miejsce 1 oraz 5) z wykorzystaniem kodu promocyjnego (Jeżeli wykonamy skrypt jeszcze raz, dostaniemy odpowiedź, że kod został już wykorzystany)
* Próba zarezerwowania miejsca 3(Zgodnie z logidką dostajemy błąd)
* Kojena poprawana rezerwacja tym, razem miejsca 4

## Business scenario
  
  Wszystkie założenia ze scenariusz zostały zaimplementowane. Jako dodatkowe zadnaie, zaimplementowana została logika `Different ticket prices`,
  która dodatkowo waliduje czy podany kod został już wykorzystany przez użytkownika.
  
  Zostało również dodanych kilka dodatkowych końcówek Restowych jak:
  * Dodawanie nowego filmu
  * Dodawanie nowej sali
  * Dodawanie nowego seansu