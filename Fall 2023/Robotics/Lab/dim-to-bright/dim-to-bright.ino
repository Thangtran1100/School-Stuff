const int ledPin = 9; // Let's use pin 9 which is a PWM pin on many Arduino boards

void setup() {
  pinMode(ledPin, OUTPUT);
}

void loop() {
  // Fade in
  for (int brightness = 0; brightness <= 255; brightness++) {
    analogWrite(ledPin, brightness);
    delay(8); // 8 milliseconds * 256 iterations = ~2 seconds fade time
  }
  // Fade out
  for (int brightness = 255; brightness >= 0; brightness--) {
    analogWrite(ledPin, brightness);
    delay(8); // 8 milliseconds * 256 iterations = ~2 seconds fade time
  }
}
