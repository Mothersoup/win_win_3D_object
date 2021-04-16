import javax.media.j3d.BranchGroup;
import com.sun.j3d.loaders.Scene;
import com.sun.j3d.loaders.objectfile.ObjectFile;
public class Load extends BranchGroup {

    /*

    about load moudle
     */
    public Load(String filePath)
    {
        BranchGroup branchGroup=new BranchGroup();
        int flag =ObjectFile.RESIZE;

        double creaseAngle = 60.0;
        ObjectFile objectFile=new ObjectFile(flag,(float)(creaseAngle*Math.PI)/180);

        Scene scene=null;

        try{
            scene=objectFile.load(filePath);
        }catch (Exception e)
        {
        e.printStackTrace();
        System.out.println("模型載入失敗"+e.getMessage());
        }
        branchGroup.addChild(scene.getSceneGroup());
        this.addChild(branchGroup);

    }
}
