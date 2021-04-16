import com.mysql.jdbc.Driver;
import com.sun.j3d.utils.applet.MainFrame;
import com.sun.j3d.utils.geometry.Primitive;
import com.sun.j3d.utils.geometry.Sphere;
import com.sun.j3d.utils.image.TextureLoader;
import com.sun.j3d.utils.universe.SimpleUniverse;

import javax.media.j3d.*;
import javax.vecmath.*;
import java.applet.Applet;
import java.awt.*;

public class Try extends Applet {
    private static void crate() {
        ///create a virtual universe
        SimpleUniverse simpleUniverse = new SimpleUniverse();
        ////this is a datastruture
        BranchGroup branchGroup = new BranchGroup();
        TransformGroup transformGroup = new TransformGroup();
        ///create a color red,green,blue
        Color3f lightRed = new Color3f(1, 0, 0);
        Color3f black = new Color3f(0.0f, 0.0f, 0.0f);

        Color3f white = new Color3f(1.0f, 1.0f, 1.0f);

        Color3f red = new Color3f(0.7f, .15f, .15f);
        //set up texture map lead texture to texture
        TextureLoader textureLoader = new TextureLoader("D:\\照片\\下載.jpg", "LUMINANCE", new Container());
        //store texture and setting radius attribute
        Texture texture = textureLoader.getTexture();
        texture.setBoundaryModeT(Texture.WRAP);
        texture.setBoundaryModeS(Texture.WRAP);
        ///the last parameter is  about transparent
        texture.setBoundaryColor(new Color4f(0.5f, 0.5f, 0.6f, 0f));

        ///setting texture attribute
        TextureAttributes textAttr = new TextureAttributes();
        textAttr.setTextureMode(TextureAttributes.MODULATE);
        Appearance appearance = new Appearance();
        appearance.setTexture(texture);
        appearance.setTextureAttributes(textAttr);
        //set up the material
        appearance.setMaterial(new Material(red, black, white, red, 1.0f));
        //create a ball to demonstrate and generate
        int primFlag = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
        Sphere sphere = new Sphere(0.75f, primFlag, appearance);
        branchGroup.addChild(sphere);
        ///create light
        Color3f light = new Color3f(0.3f, 0f, 1.0f);
        ///position
        BoundingSphere bounds = new BoundingSphere(new Point3d(0.0, 0.0, 0.0), 100.0);
        Vector3f lightDirection = new Vector3f(4.0f, -7.0f, -12.0f);
        DirectionalLight light1 = new DirectionalLight(light, lightDirection);
        light1.setInfluencingBounds(bounds);
        AmbientLight ambientLight = new AmbientLight(new Color3f(0.5f, 0.5f, 0.5f));
        ambientLight.setInfluencingBounds(bounds);
        branchGroup.addChild(ambientLight);
        branchGroup.addChild(light1);
        ///define a ball radius
        ///position this sphere x,y,z

        ///trans View
        simpleUniverse.getViewingPlatform().setNominalViewingTransform();
        ///add object in datastructre
        simpleUniverse.addBranchGraph(branchGroup);

    }
static Conne conne=new Conne();
    public static void main(String[] args) {
        conne.Driver();
        /// Second second=new Second();
        ///  Second.vector();
        /// Figure figure=new Figure();
        ///new MainFrame(figure,400,400);
        System.setProperty("sun.awt.noerasebackground", "true");
       // DrawingExample object = new DrawingExample();
        ///object.frame = new MainFrame(object, args, object.imageWidth, object.imageHeight);
        ///object.validate();
       ///new Pick();
        new Combin();
    }
}
