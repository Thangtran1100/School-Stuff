const int ledPin = 8; // Assuming we're using the onboard LED for most Arduino boards

const int shortBlink = 200;  // Duration for short blink in milliseconds
const int longBlink = 600;   // Duration for long blink in milliseconds

const int shortPause = 200;  // Duration for short pause in milliseconds
const int longPause = 600;   // Duration for long pause between letters and repetitions

void setup() {
  pinMode(ledPin, OUTPUT);
}

void loop() {
  // S: 3 short blinks
  for (int i = 0; i < 3; i++) {
    blink(ledPin, shortBlink);
    delay(shortPause);
  }

  // O: 3 long blinks
  for (int i = 0; i < 3; i++) {
    blink(ledPin, longBlink);
    delay(shortPause);
  }

  // S: 3 short blinks
  for (int i = 0; i < 3; i++) {
    blink(ledPin, shortBlink);
    if (i < 2) {  // No need for a pause after the last blink, as there's a long pause afterwards
      delay(shortPause);
    }
  }

  // Pause between repetitions
  delay(longPause);
}

void blink(int pin, int duration) {
  digitalWrite(pin, HIGH);
  delay(duration);
  digitalWrite(pin, LOW);
}
