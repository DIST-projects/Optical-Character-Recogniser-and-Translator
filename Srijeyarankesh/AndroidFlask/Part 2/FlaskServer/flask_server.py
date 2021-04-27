import flask
import werkzeug
#import keras.models
#import numpy
#import scipy.misc
#import imageio
import PIL
#from PIL import ImageDraw
import sky

app = flask.Flask(__name__)

@app.route('/', methods = ['GET', 'POST'])
def handle_request():
    imagefile = flask.request.files['image0']
    filename = werkzeug.utils.secure_filename(imagefile.filename)
    str = sky.p(filename)
    print("\nReceived image File name : " + imagefile.filename)
   
    
    im = PIL.Image.open(str)
    im.show()
  
    return "Image uploaded Successfully"
  
app.run(host="0.0.0.0", port=5000, debug=True,use_reloader=False)
   
  
   
