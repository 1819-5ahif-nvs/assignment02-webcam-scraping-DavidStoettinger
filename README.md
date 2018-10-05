# LinkWatcher

## Ausgangssituation

Es gibt Websites mit WebCams zB: <https://dachstein-salzkammergut.com/de/aktuelles/live-vom-berg/webcam/>

Möchte man sich die Videos einzeln ansehen, so kann man den Ursprungsstream sich komfortabel aus dem HTML-Code holen, zB für den Krippenstein <https://webtv.feratel.com/webtv/?cam=5132&design=v3&c0=0&c2=1&lg=en&s=0>

Im Video-Element mit der id "fer_video" findet man nun eine (aktuelle) mp4-Datei zB 

<https://streamsrv54.feratel.co.at/streams/1/05132_5bb48207-dcc2Vid.mp4?dcsdesign=feratel4>

## Aufgabenstellung

### Client programmieren

Es soll nun überprüft werden, ob sich der Link für den Krippenstein ändert (ist ja "nur" ein mp4-File).

Erstellen Sie dazu ein kleines Java- oder Kotlin-Programm, welches jede Minute einen Request auf die Website absetzt. Anschließend scrapen Sie den Link auf den Krippenstein und schreiben ihn in eine Log-Datei (inkl. Timestamp). So können Sie feststellen, mit welcher Periodizität das Video aktualisiert wird.

Weiters überprüfen Sie, ob sich der Link zum letzten Mal geändert hat, denn dann schicken Sie ein email an sich selbst, um informiert zu werden.

### Jar-file für Client erstellen

Der Client soll auf einem RaspberryPi funktionieren, dh das Programm muss außerhalb der IDE funktionieren. Sie müssen also mit Maven ein jar-File generieren, daß alle Abhängigkeiten (zB JSoup) beinhaltet.

Verwenden Sie hierzu zB Appache Shade

### Dokumentation

Dokumentieren Sie Ihre Arbeit. Gehen Sie dabei auf die Schlüsselstellen ein.

### Android-App

Erstellen Sie eine Android - App, die das jeweils aktuelle Video abspielt.

## Tipps

Verwenden Sie zum scrapen JSoup (auch mit Kotlin)
<https://www.google.com/search?q=jsoup+kotlin&ie=utf-8&oe=utf-8&client=firefox-b-ab>
siehe insbesonders <https://github.com/fcannizzaro/ksoup>

Sie können ev. auch Selenium verwenden.
