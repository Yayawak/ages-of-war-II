import cv2
import numpy as np
from PIL import Image
import os
import matplotlib.pyplot as plt
# os.path()
# w = os.walk("./")
# for wi in w:
#     print(wi)
# for file in os.listdir()
path = "./"
for f in os.listdir():
    if os.path.isdir(os.path.join(path, f)):
        if (f.startswith(".")): continue
        
        j = os.path.join(path, f)
        print(j)
        for img_file in os.listdir(j):
            rel_path = os.path.join(j, img_file)
            # print(img_file)
            # print(rel_path)
            # try:
            print(rel_path)
            # if not rel_path.startswith("."):
            if True:
                # img = Image.open(rel_path)
                # img_flipped = img.transpose(method=Image.FLIP_LEFT_RIGHT)
                # img_flipped.save(rel_path)
                # img = np.array(Image.open(rel_path))
                # img_flipped = ImageOps.mirror(img)
                # img_flipped.save(rel_path)
                img = cv2.imread(rel_path, cv2.IMREAD_UNCHANGED)
                imf = cv2.flip(img, 1)
                cv2.imwrite(rel_path, imf)
                
            # except:
                # ...
            # img = cv2.imread(rel_path)
            # img_h = cv2.flip(img, 1)
            # cv2.imwrite(rel_path, img_h)
        print("------------")

