import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.laura.havagas.R

class MainActivity : AppCompatActivity() {
    private var name: String = ""
    private var email: String = ""
    private var receiveEmails: Boolean = false

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("name", name)
        outState.putString("email", email)
        outState.putBoolean("receiveEmails", receiveEmails)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etName: EditText = findViewById(R.id.etName)
        val etEmail: EditText = findViewById(R.id.etEmail)
        val cbReceiveEmails: CheckBox = findViewById(R.id.cbReceiveEmails)
        val btnSave: Button = findViewById(R.id.btnSave)
        val btnClear: Button = findViewById(R.id.btnClear)

        if (savedInstanceState != null) {
            name = savedInstanceState.getString("name", "")
            email = savedInstanceState.getString("email", "")
            receiveEmails = savedInstanceState.getBoolean("receiveEmails", false)

            etName.setText(name)
            etEmail.setText(email)
            cbReceiveEmails.isChecked = receiveEmails
        }

        btnSave.setOnClickListener {
            val name = etName.text.toString()
            val email = etEmail.text.toString()
            val receiveEmails = cbReceiveEmails.isChecked

            val message = """
                Nome: $name
                E-mail: $email
                Deseja receber em-mails?: ${if (receiveEmails) "Sim" else "Não"}
                """.trimIndent()

            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        }

        btnClear.setOnClickListener {
            etName.text.clear()
            etEmail.text.clear()
            cbReceiveEmails.isChecked = false
        }
    }
}
