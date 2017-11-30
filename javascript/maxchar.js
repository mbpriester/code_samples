// --- Directions
// Given a string, return the character that is most
// commonly used in the string.
// --- Examples
// maxChar("abcccccccd") === "c"
// maxChar("apple 1231111") === "1"

function maxChar(str) {
  const charMap = {};
  var topChar = 0;
  var maxChars;

  for(let char of str){
    charMap[char] = charMap[char] + 1 || 1;

    if(charMap[char] > topChar){
      topChar = charMap[char];
      maxChars = char;
    }

  }

  return maxChars;
}

module.exports = maxChar;
