import React from "react";
import QRCode from "qrcode.react";
import "./PaymentStyles.css";

const QRCodeAndPayment = ({ upiId, payeeName, amount }) => {
  const upiUrl = `upi://pay?pa=${upiId}&pn=${payeeName}&am=${amount}&cu=INR`;

  const handleRazorpay = () => {
    const options = {
      key: "rzp_test_yourKey", //razor free test key needs to be added for testing
      amount: amount * 100,
      currency: "INR",
      name: payeeName,
      description: "Product Payment",
      prefill: {
        name: payeeName,
        email: "demo@example.com",
        contact: "9999999999",
      },
      theme: {
        color: "#00b894",
      },
    };
    if (typeof window !== "undefined" && window.Razorpay) {
            const rzp = new window.Razorpay(options);
            rzp.open();
    } else {
        alert("Razorpay script not loaded yet.");
    }
  };

  return (
    <div className="payment-container">
      <h2>Pay ₹{amount}</h2>

      <div className="qr-box">
        <QRCode value={upiUrl} size={180} />
        <p>Scan this QR with any UPI app</p>
        <a href={upiUrl} target="_blank" rel="noopener noreferrer">
          <button className="upi-btn">Pay via UPI App</button>
        </a>
      </div>

      <hr className="divider" />

      <button className="razorpay-btn" onClick={handleRazorpay}>
        Pay with Razorpay
      </button>
    </div>
  );
};

export default QRCodeAndPayment;