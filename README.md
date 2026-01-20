# otp-verification-registration-service-dummy

[POST] http://localhost:8080/register/init
{
  "mobile": "8210819444"
}

[POST] http://localhost:8080/register/verify
{
  "mobile": "8210819444",
  "otp": "921551"
}
