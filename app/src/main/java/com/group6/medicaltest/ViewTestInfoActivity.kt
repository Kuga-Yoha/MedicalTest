import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.group6.medicaltest.R
import com.group6.medicaltest.TestViewModel

class ViewTestInfoActivity : AppCompatActivity() {

    private lateinit var testViewModel: TestViewModel
    private lateinit var textViewTestId: TextView
    private lateinit var textViewBPL: TextView
    private lateinit var textViewBPH: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_test_info)

        // Initialize UI elements
        textViewTestId = findViewById(R.id.textViewTestId)
        textViewBPL = findViewById(R.id.textViewBPL)
        textViewBPH = findViewById(R.id.textViewBPH)

        // Assuming you have a ViewModel class for Test
        testViewModel = ViewModelProvider(this).get(TestViewModel::class.java)

        // Get the patientId from the Intent (you need to pass it from the previous activity)
        val patientId = intent.getIntExtra("patientId", -1)

        // Fetch and observe test data for the given patient
//        testViewModel.getTestsForPatient(patientId).observe(this, { tests ->
//            if (tests.isNotEmpty()) {
//                val firstTest = tests[0]
//                textViewTestId.text = "Test ID: ${firstTest.testId}"
//                textViewBPL.text = "BPL: ${firstTest.BPL}"
//                textViewBPH.text = "BPH: ${firstTest.BPH}"
//            } else {
//
//            }
//        })
    }
}
