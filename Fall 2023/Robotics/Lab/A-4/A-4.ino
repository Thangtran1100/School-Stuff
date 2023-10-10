const int ledPin = 8;  // Assuming the LED is connected to digital pin 13

void setup() {
  pinMode(ledPin, OUTPUT);
}

void loop() {
  for (int i = 0; i <= 255; i++) {
    digitalWrite(ledPin, HIGH);
    delayMicroseconds(i * 8);  // Adjust the ON time
    digitalWrite(ledPin, LOW);
    delayMicroseconds(2048 - i * 8);  // Adjust the OFF time
  }

  for (int i = 255; i >= 0; i--) {
    digitalWrite(ledPin, HIGH);
    delayMicroseconds(i * 8);  // Adjust the ON time
    digitalWrite(ledPin, LOW);
    delayMicroseconds(2048 - i * 8);  // Adjust the OFF time
  }
}
