import './App.css';
import QRCodeAndPayment from './Components/QRCodeAndPayment';

function App() {
  return (
    <div className="App">
      <QRCodeAndPayment upiId="yourupi@okaxis" payeeName="Shreyas Kumar" amount={250} />
    </div>
  );
}

export default App;
