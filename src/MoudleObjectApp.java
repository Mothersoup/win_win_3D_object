import com.sun.j3d.utils.universe.SimpleUniverse;

import javax.media.j3d.*;
import javax.vecmath.Color3f;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3f;
import java.applet.Applet;
import java.awt.*;

public class MoudleObjectApp extends Applet {

    private float speed = 50;
    static Depencies  depencies=new Depencies();


    ///建立場景分支圖

    /**
     * protected BranchGroup createBranch()
     * {
     * BranchGroup group=new BranchGroup();
     * ///幾何變換節點
     * <p>
     * TransformGroup transGroup=new TransformGroup();
     * <p>
     * Transform3D transform3D=new Transform3D();
     * ///幾何變換
     * transform3D.setScale(0.8);
     * ///縮放變化
     * transGroup.setTransform(transform3D);
     * ///將幾何變化新增進場景
     * group.addChild(transGroup);
     * ///將幾何變化新增置場景
     * BoundingSphere bound=new BoundingSphere( new Point3d(0.0,0.0,0.0),100);
     * ///球體作用範圍邊界物件
     * Color3f    backgroundColor=new Color3f(0.05f,0.05f,0.2f);
     * Background background=new Background(backgroundColor);
     * background.setApplicationBounds(bound);
     * group.addChild(background);
     * ///設定光源
     * Color3f lightColor=new Color3f(1.0f,1.0f,0.9f);
     * Vector3f lightStart=new Vector3f(4.0f,-7.0f,-12.0f);
     * DirectionalLight directionalLight=new DirectionalLight(lightColor,lightStart);
     * ///設定光源影響範圍
     * directionalLight.setInfluencingBounds(bound);
     * group.addChild(directionalLight);
     * <p>
     * TransformGroup objectModule=new TransformGroup();
     * objectModule.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
     * ///載入obj檔志節點
     * objectModule.addChild(new Load("D:/race.obj"));
     * ///將模型新增至變換組節點
     * transGroup.addChild(objectModule);
     * ///set geometry trans
     * Transform3D yAxis=new Transform3D();
     * Transform3D xAxis=new Transform3D();
     * Alpha rotationAlpha=new Alpha(-1,Alpha.INCREASING_ENABLE,5,0,9000,0,0,4,0,0);
     * ///increasing means add and decreasing means subtract
     * RotationInterpolator rotator=new RotationInterpolator(
     * rotationAlpha,objectModule,yAxis,speed,(float)Math.PI*2.0f);///
     * <p>
     * rotator.setSchedulingBounds(bound);
     * ///objectModule.addChild(rotator);
     * Point3d x=new Point3d();
     * ///將滑鼠設定其中
     * group.compile();
     * return group;
     * }
     **/

    protected MoudleObjectApp() {
        SimpleUniverse simpleUniverse = new SimpleUniverse();

        BranchGroup branchGroup = new BranchGroup();

        branchGroup.addChild(node());

        simpleUniverse.getViewingPlatform().setNominalViewingTransform();

        simpleUniverse.addBranchGraph(branchGroup);
    }

    public Node node() {
        double radius = 0.3;
        TransformGroup model = new TransformGroup();

        model.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

        model.addChild(new Load("D:/race.obj"));

        /**  Transform3D transOrigin= new Transform3D();

         Transform3D transform = new Transform3D();

         transform.setTranslation(new Vector3d(0.0,-radius,0.0));

         transform.mul(transform,transOrigin);

         Transform3D rotateX =new Transform3D();
         rotateX.rotX(Math.PI);

         transOrigin.mul(rotateX,transOrigin);
         ///take care of backside
         Transform3D transBack=new Transform3D();

         transBack.setTranslation(new Vector3d(0.0,radius,0.0));

         transOrigin.mul(transBack,transOrigin);

         model.setTransform(transOrigin);**/
        return model;
    }

    private static final long seriesVersionUID = 5841679659336190804L;

    public static BranchGroup createBranch(int x, int y, int z) {
        BranchGroup group = new BranchGroup();

        TransformGroup transGroup = new TransformGroup();

        Transform3D transform3D = new Transform3D();

        transform3D.setScale(0.8);

        transGroup.setTransform(transform3D);

        group.addChild(transGroup);

        BoundingSphere bound = new BoundingSphere(new Point3d(0.0, 0.0, 0.0), 100.0);
        Color3f backgroundColor = new Color3f(0.05f, 0.05f, 0.2f);
        Background background = new Background(backgroundColor);

        background.setApplicationBounds(bound);
        group.addChild(background);
        Color3f lightColor = new Color3f(1.0f, 1.0f, 0.9f);
        Vector3f lightVector = new Vector3f(4.0f, -7.0f, -12.0f);

        DirectionalLight light = new DirectionalLight(lightColor, lightVector);
        light.setInfluencingBounds(bound);

        group.addChild(light);
        TransformGroup objtrans = new TransformGroup();
        objtrans.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        objtrans.addChild(new Test_rotate("D:\\race.obj"));
        transGroup.addChild(objtrans);
        ///process the rotate problem
        depencies.setTransfromGroup(transGroup);
        Rotate(transGroup, x, y, z);
        group.compile();
        return group;
    }



    public static void Rotate(TransformGroup objectInteraction, double dh, double dp, double dr) {
        Transform3D origin = new Transform3D();
        objectInteraction.setTransform(origin);
        Transform3D tx = new Transform3D();
        Transform3D ty = new Transform3D();
        Transform3D tz = new Transform3D();

        ///camera
        Transform3D tc = new Transform3D();
///may be modify waiting ...
        double x = 0, y = 0, z = 0;
        x = Math.PI * dh / 180;
        y = Math.PI * dp / 180;
        z = Math.PI * dr / 180;
        tx.rotX(x);
        tc.mul(tx);

        ty.rotY(y);
        tc.mul(ty);

        tz.rotZ(z);
        tc.mul(tz);

        origin.mul(tc);

        objectInteraction.setTransform(origin);

    }

    public MoudleObjectApp(BranchGroup create) {

        setLayout(new BorderLayout());
        // 创建3D场景绘制画布Canvas3D对象
        GraphicsConfiguration config=SimpleUniverse.getPreferredConfiguration();
        Canvas3D canvas = new Canvas3D(config);
        add("Center", canvas);
        BranchGroup scene = create;

        SimpleUniverse universe = new SimpleUniverse(canvas);
        universe.getViewingPlatform().setNominalViewingTransform();
        universe.addBranchGraph(scene);
    }
}
