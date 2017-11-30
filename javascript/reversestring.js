// --- Directions
// Given a string, return a new string with the reversed
// order of characters
// --- Examples
//   reverse('apple') === 'leppa'
//   reverse('hello') === 'olleh'
//   reverse('Greetings!') === '!sgniteerG'

function reverse(str) {
  var reversed = "";
  var i;
  for(i=str.length; i >= 0; i--){
    reversed = reversed + str.charAt(i);
  }
  return reversed;
}



module.exports = reverse;
