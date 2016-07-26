function add_mask(input_field, m_function) {

    field           = input_field;
    mask_function   = m_function;

    setTimeout("execute_mask()", 1);
}

function execute_mask() {

    field.value = mask_function(field.value);
}

function cpf_mask(character) {

    character = number_only(character);

    character = character.replace(/(\d{3})(\d)/, "$1.$2");
    character = character.replace(/(\d{3})(\d)/, "$1.$2");
    character = character.replace(/(\d{3})(\d)/, "$1-$2");

    return character;
}

function number_only(character) {

    character = character.replace(/\D/g, "");

    return character;
}