package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions){
       Image image=new Image();
       image.setDescribtion(description);
       image.setDimensions(dimensions);

       Blog blog = blogRepository2.findById(blogId).get();

       image.setBlog(blog);
       List<Image>images=blog.getImageList();
       images.add(image);
       blog.setImageList(images);

       //blogRepository2.save(blog);
       //imageRepository2.save(image);

       return image;
    }

    public void deleteImage(Integer id){
          imageRepository2.deleteById(id);
    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
         String screenArray[]=screenDimensions.split("X");

         Image image=imageRepository2.findById(id).get();

         String imageArray[]=image.getDimensions().split("X");

         int screenLength=Integer.parseInt(screenArray[0]);
         int screenBreadth=Integer.parseInt(screenArray[1]);

         int imageLength=Integer.parseInt(imageArray[0]);
         int imageBreadth=Integer.parseInt(imageArray[1]);

         int len=screenLength/imageLength;
         int bre=screenBreadth/imageBreadth;

         return len*bre;
    }
}
