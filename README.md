#OCR Project (Hindi)

The project enables the user to take a picture and upload it onto the web application thereby helping in identifying the Hindi text and translate it into English.

##Detection and Recognition
 For Detection we use the EAST (Efficient and Accurate Scene Text Detetction Model) [Research paper on EAST](https://arxiv.org/abs/1704.03155) to find the area wherein text lies and draw a bounding box around it.
 For Recognition we use CRNN (Convolutional Recurrant Neural Network) [Research paper on CRNN architecture](https://arxiv.org/pdf/1702.06286).
 The CRNN consists of ResNet for feature extraction, LSTM for generating prediction sequences and CTC loss funtion to calculate loss.

##Machine Transliteration
 For Machine Transliteration we convert hindi text to corresponding english text.

##Web application
  Building a proper UI at the frontend and employ Transfer Learning by embedding the pre-trained model onto the web app.





