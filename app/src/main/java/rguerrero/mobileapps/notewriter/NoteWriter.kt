package rguerrero.mobileapps.notewriter
import android.content.Context
import android.os.Environment
import android.util.Log
import java.io.File


class NoteWriter {




    fun isExternalStorageWritable() : Boolean{
        val state = Environment.getExternalStorageState()
        return Environment.MEDIA_MOUNTED.equals(state)
    }

    fun getAlbumStorageDir(albumName:String) : File{
        val file = File(
            Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES
            ), albumName
        )
        if (!file.mkdirs()) {
            Log.e(LOG_TAG, "Directory not created")
        }
        return file
    }

    fun guardarArchivoInterno(nombre:String,cuerpo:String){
        val titulo = nombre + ".txt"
        val fos = openFileOutput(titulo, Context.MODE_PRIVATE)
        fos.write(cuerpo.toByteArray())
        fos.close)


    }


}