# Universal Turing Machine

Dieses Projekt implementiert eine universelle Turingmaschine in Java. Die Turingmaschine kann eine binär kodierte Turingmaschine interpretieren und auf einem Band ausführen.

## Projektbeschreibung

Der Universal Turing Machine Simulator kann:
- Binär kodierte Turingmaschinen-Definitionen einlesen
- Diese in verständliche Transitionen umwandeln
- Die Turingmaschine mit benutzerdefinierter Eingabe ausführen
- Im Schritt-für-Schritt-Modus oder kontinuierlich arbeiten
- Den aktuellen Zustand des Bands und des Rechenprozesses anzeigen

## Verwendung

1. Kompilieren und starten Sie das Programm
2. Geben Sie die binäre Kodierung Ihrer Turingmaschine ein
3. Geben Sie die Eingabe für die Turingmaschine ein
4. Wählen Sie, ob Sie im Schritt-für-Schritt-Modus arbeiten möchten
5. Beobachten Sie die Ausführung und das Ergebnis

## Projektstruktur

- `Main.java`: Einstiegspunkt der Anwendung
- `TuringMachine.java`: Implementierung der Turingmaschine
- `Transition.java`: Repräsentation einer Übergangsfunktion
- `IOHandler.java`: Ein-/Ausgabesteuerung

## 🎓 Hinweis für THIN-Kursteilnehmer an der ZHAW 🎓

Hey du! Auf der Suche nach Inspiration für deine THIN-Aufgabe? 🕵️‍♂️

Natürlich *könntest* du diesen Code kopieren - die Turingmaschine würde das nie verraten! Aber denk daran: Wenn du nur kopierst, ohne zu verstehen, ist das wie eine Turingmaschine ohne Band - ziemlich sinnlos! 😉

Tipp: Schau dir den Code an, verstehe ihn, und mach ihn zu deinem eigenen Meisterwerk. Deine Kreativität wird die Dozierenden mehr beeindrucken als ein verdächtiges Déjà-vu.

*PS: Die eigentliche Lösung ist manchmal nicht der Code selbst, sondern der Weg dorthin... und manchmal ist der Weg einfach ein gut platziertes Strg+C/Strg+V* 😏🤫

## Anforderungen

- Java 17 oder höher

## Inspirationsquelle

Die Logik dieser Implementierung ist inspiriert von [universal-turing-machine.ch](https://universal-turing-machine.ch/).
