import com.sun.j3d.loaders.Scene;
import com.sun.j3d.loaders.objectfile.ObjectFile;

import javax.media.j3d.Background;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Color3f;
import java.io.FileNotFoundException;

public class Test_rotate extends BranchGroup{

    private double creaseAngle=60.0;
    public Test_rotate(String filePath)
    {
    BranchGroup branchGroup=new BranchGroup();
    int flags= ObjectFile.RESIZE;
    ObjectFile objectFile=new ObjectFile(flags,(float)(creaseAngle*Math.PI)/180);
    Scene scenen= null;
    try{
        scenen=objectFile.load(filePath);

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    branchGroup.addChild(scenen.getSceneGroup());
    this.addChild(branchGroup);
    }


}
