document.querySelector('#name').addEventListener('blur', () =>{
    const na = document.getElementById('name');
    const re = /^[A-Za-z]{2,10}$/;

    if(!re.test(na.value)){
        Swal.fire(
            'error',
            'Enter the valid Name',
            'error'
          )
    }
})

document.querySelector('#email').addEventListener('blur',() =>{
    const em = document.getElementById('email');
    const re = /^([a-zA-Z0-9_\-\.]+)@([a-zA-Z0-9_\-\.]+)\.([a-zA-Z]{2,5})$/;

    if(!re.test(em.value)){
        Swal.fire(
            'error',
            'Enter the Valid Email ',
            'error'
          )
    }
})

document.querySelector('#password').addEventListener('blur',() =>{
    const pa = document.getElementById('password');
    if((pa.value) === ""){
        Swal.fire(
            'error',
            'Please fill the Password',
            'error'
          )
    }
})

document.querySelector('#number').addEventListener('blur', () => {
    const num = document.getElementById('number');
    const re = /^[0-9]{10}$/;

    if(!re.test(num.value)){
        Swal.fire(
            'error',
            'Please Enter the 10 Digit mobile Number',
            'error'
          )
            }
})

document.querySelector('.form-btn').addEventListener('click', () => {
    const Toast = Swal.mixin({
        toast: true,
        position: 'top-end',
        showConfirmButton: false,
        timer: 1000
      });
      
      Toast.fire({
        type: 'success',
        title: 'Signed in successfully'
      })
})

