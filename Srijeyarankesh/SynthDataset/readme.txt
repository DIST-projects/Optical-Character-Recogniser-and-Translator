- The whole Dataset is divided into three part for flexibility.
- Each part consists of two folders 1. Annotation, 2. Image
- The Dataset consist of approx ~ 100,000 Images, along with there annotations.
- The Images and Annotations are distributed among 25 folders, which have serial no. 1 to 25.
- Annotation for a particular image can be found in corresponding serial no. Folder for annotation with the same name. E.g., Image 4.jpg in Folder 2 in Image folder will have it's annotation in Folder 2 inside Annotation Directory with the name 4.txt.

- Understanding Annotation file.
- Each line in the annotation file represents a word bounding box.
- Suppose there are four lines of text in a file, then there will be 4-word bounding will be there in the image.
- The last word of each line represents ground truth.
- The first four value of line represents x1, x2, x3, x4, which are x-coordinate in clockwise order. x1 represent top-left, x2 represent top-right, x3 represent bottom-right, x4 represent bottom left.
- Similarly, after the first four next four represents y1, y2, y3, y4, which are x-coordinate in clockwise order. y1 represents top-left, y2 represent top-right, y3 represents bottom-right, y4 represent bottom left.
- A line can be seen as x1_x2_x3_x4_y1_y2_y3_y4_groundTruth, where '_' represents single space.

An example of an annotation file is.

15.025299 79.619064 91.971375 27.37761 111.49409 87.36937 120.44259 144.5673 और
195.26416 345.93964 346.07916 195.40369 296.7271 296.54498 411.9508 412.13293 किस
544.8015 579.83813 541.4978 506.46115 42.720642 60.455795 136.19897 118.46382 दिन
275.59427 311.88095 302.1434 265.85672 134.48518 159.5067 173.62825 148.60674 रूप
30.469978 163.88913 164.9093 31.490135 182.98358 181.51782 274.3758 275.84155 इस
33.57235 184.95844 185.26584 33.879738 354.1837 353.62552 436.9943 437.55246 तरह
-2.6164436 45.761616 53.37768 4.9996223 155.51007 137.70114 158.39023 176.19916 साथ
343.8163 512.32336 512.94495 344.4379 134.2903 132.54332 192.49599 194.24297 एकाएक
337.52948 504.81384 505.13098 337.84662 241.95956 240.91986 291.94846 292.98816 रमानाथ
507.9361 555.0499 523.0799 475.96606 4.7673645 56.682793 85.69593 33.780502 गया

It consists of 10 lines, so 10-word level bounding boxes are there. GroundTruth is the last.
x1 x2 x3 x4 y1 y2 y3 y4 order is there.
