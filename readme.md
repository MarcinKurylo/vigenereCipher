# Vigenère autokey cipher

### Java implementation of [Vigènere cipher](https://en.wikipedia.org/wiki/Vigenère_cipher).

Key is generated automatically through
iterating over plaintext with one supplementary 
char added to the begging of plaintext.

Encoding : E = (P+K) % 26 ;where
* P - plain text letter,
* K - key letter,
* E - encrypted letter.

Encoding : D = (E-K) % 26 ;where
* E - encrypted letter,
* K - key letter,
* D - decrypted letter.

If D < 0 ==> D+26;

Algorithm ignores characters other than letters.


