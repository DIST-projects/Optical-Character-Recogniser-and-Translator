# OCR Project (Hindi)

The project enables the user to take a picture and upload it onto the web application thereby helping in identifying the Hindi text and translate it into English.

## Detection and Recognition
 For Detection we use the EAST (Efficient and Accurate Scene Text Detection Model) [Research paper on EAST](https://arxiv.org/abs/1704.03155) to find the area wherein text lies and draw a bounding box around it.
 For Recognition we use CRNN (Convolutional Recurrant Neural Network) [Research paper on CRNN architecture](https://arxiv.org/pdf/1702.06286).
 The CRNN consists of ResNet for feature extraction, LSTM for generating prediction sequences and CTC loss funtion to calculate loss.

## Machine Translation
 For Machine Translation, we convert Hindi Indic text to corresponding English text using an custom made API developed to take the text from our recogition CRNN algorithm and uses the entrusted GToken key which obtains a ticket mechanism to obtain its translated desired output. Once the key is obtained, translation can be done with any textual input with accurate outputs being immediately received.

## Mobile application
  To Build a mobile application using Flutter with an interactive UI and deploy the pre-trained models for efficient and robust output. The plan is to embed our Machine Learning Model along with our translation algorithm to create a convenient and user enhanced experience which is quick, robust and accurate with its output.





