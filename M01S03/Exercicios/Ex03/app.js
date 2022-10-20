const arr1 = [1, 2, 3];
const arr2 = [4, 5, 6];

//Function
function Concatena(array1, array2){

        return array1.concat(array2);

}

//Arrow Function 
const Concatena2 = (array1, array2) => array1.concat(array2);

console.log(Concatena2(arr1,arr2));