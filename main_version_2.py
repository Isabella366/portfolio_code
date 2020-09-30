import random
#creates base deck deck may need to be altered for value of aces for specific games
original_deck =[{'suit': 'hearts', 'face': 'king', 'value': 13},
        {'suit': 'hearts', 'face': 'queen', 'value': 12},
        {'suit': 'hearts', 'face': 'jack', 'value': 11},
        {'suit': 'hearts', 'face': 'ten', 'value': 10},
        {'suit': 'hearts', 'face': 'nine', 'value': 9},
        {'suit': 'hearts', 'face': 'eight', 'value': 8},
        {'suit': 'hearts', 'face': 'seven', 'value': 7},
        {'suit': 'hearts', 'face': 'six', 'value': 6},
        {'suit': 'hearts', 'face': 'five', 'value': 5},
        {'suit': 'hearts', 'face': 'four', 'value': 4},
        {'suit': 'hearts', 'face': 'three', 'value': 3},
        {'suit': 'hearts', 'face': 'two', 'value': 2},
        {'suit': 'hearts', 'face': 'ace', 'value': 1},
        {'suit': 'spades', 'face': 'king', 'value': 13},
        {'suit': 'spades', 'face': 'queen', 'value': 12},
        {'suit': 'spades', 'face': 'jack', 'value': 11},
        {'suit': 'spades', 'face': 'ten', 'value': 10},
        {'suit': 'spades', 'face': 'nine', 'value': 9},
        {'suit': 'spades', 'face': 'eight', 'value': 8},
        {'suit': 'spades', 'face': 'seven', 'value': 7},
        {'suit': 'spades', 'face': 'six', 'value': 6},
        {'suit': 'spades', 'face': 'five', 'value': 5},
        {'suit': 'spades', 'face': 'four', 'value': 4},
        {'suit': 'spades', 'face': 'three', 'value': 3},
        {'suit': 'spades', 'face': 'two', 'value': 2},
        {'suit': 'spades', 'face': 'ace', 'value': 1},

        {'suit': 'diamonds', 'face': 'king', 'value': 13},
        {'suit': 'diamonds', 'face': 'queen', 'value': 12},
        {'suit': 'diamonds', 'face': 'jack', 'value': 11},
        {'suit': 'diamonds', 'face': 'ten', 'value': 10},
        {'suit': 'diamonds', 'face': 'nine', 'value': 9},
        {'suit': 'diamonds', 'face': 'eight', 'value': 8},
        {'suit': 'diamonds', 'face': 'seven', 'value': 7},
        {'suit': 'diamonds', 'face': 'six', 'value': 6},
        {'suit': 'diamonds', 'face': 'five', 'value': 5},
        {'suit': 'diamonds', 'face': 'four', 'value': 4},
        {'suit': 'diamonds', 'face': 'three', 'value': 3},
        {'suit': 'diamonds', 'face': 'two', 'value': 2},
        {'suit': 'diamonds', 'face': 'ace', 'value': 1},

        {'suit': 'clubs', 'face': 'king', 'value': 13},
        {'suit': 'clubs', 'face': 'queen', 'value': 12},
        {'suit': 'clubs', 'face': 'jack', 'value': 11},
        {'suit': 'clubs', 'face': 'ten', 'value': 10},
        {'suit': 'clubs', 'face': 'nine', 'value': 9},
        {'suit': 'clubs', 'face': 'eight', 'value': 8},
        {'suit': 'clubs', 'face': 'seven', 'value': 7},
        {'suit': 'clubs', 'face': 'six', 'value': 6},
        {'suit': 'clubs', 'face': 'five', 'value': 5},
        {'suit': 'clubs', 'face': 'four', 'value': 4},
        {'suit': 'clubs', 'face': 'three', 'value': 3},
        {'suit': 'clubs', 'face': 'two', 'value': 2},
        {'suit': 'clubs', 'face': 'ace', 'value': 1}]

# functions go here


def black_jack_deck (cards):
    for card in cards:
        if card["face"] == "king" or card["face"] == "queen" or card["face"] == "jack":
            card["value"] = 10

    return cards


def shuffled(deck):
    shuffled_deck = random.sample(deck, k=len(deck))
    return shuffled_deck


def deal(deck, quantity):
    dealt_cards = []
    counter = 1
    while counter <= quantity:
        dealt_cards.append(deck[0])
        deck.pop(0)
        counter += 1
    return dealt_cards


def print_cards(cards):
    results = []
    for card in cards:
        results.append(card['face'])
        results.append(card['suit'])
    return results


def add_values(cards):
    total = 0
    for card in cards:
        total = total + card["value"]
    return total


def hit(cards, users_cards):
    new_card = cards[0]
    users_cards = users_cards.append(new_card)
    cards.pop(0)
    return users_cards


def check_ace(cards):

    for card in cards:
        if card["face"] == "ace":
            value = int(input("Do you want this Ace to be worth 1 or 11"))
            card["value"] = value
    return cards

def check_dealers_ace(cards,total_value): # CHECK THIS!
    for card in cards:
        if card["face"] == "ace":
            if total_value + 10 <= 20:
                card["value"] = 10
            else:
                card["value"] = 1
        return cards



#game set up

bj_deck = black_jack_deck(original_deck) #creates new deck
bj_deck = shuffled(bj_deck) #shuffles the above deck and updates its value

#deals cards and prepares them for printing
players_cards = deal(bj_deck, 2)
check_ace(players_cards)
dealers_cards = deal(bj_deck, 2)

dealers_first_card = []
dealers_first_card.append(dealers_cards[0])
dealers_second_card = []
dealers_second_card.append(dealers_cards[1])


#add the values of the displayed cards
players_total = add_values(players_cards)
dealers_total = add_values(dealers_first_card)
check_dealers_ace(dealers_cards,dealers_total)

#prints cards (only first dealers card the other is covered at this point) and the totals of the cards

print("The Players cards are: {}. For a total value of: {}".format(print_cards(players_cards), players_total))
print("The Dealers cards are:{}. For a total value of: {}".format(print_cards(dealers_first_card), dealers_total))


#game begins
while players_total < 21 and dealers_total < 17:
    move = input("Do you want to STAND or HIT?")
    move = move.upper()
    if move == "HIT":
        hit(bj_deck,players_cards)
        check_ace(players_cards)
        players_total = add_values(players_cards)

        print("The Players cards are: {}. For a total value of: {}".format(print_cards(players_cards), players_total))
    elif move =="STAND":
        #get the dealers cards and display the second card and add the value of the dealers cards
        dealers_total = add_values(dealers_first_card) + add_values(dealers_second_card)
        check_dealers_ace(dealers_cards,dealers_total)
        print("The Dealers cards are:{} {}. For a total value of: {}".format(print_cards(dealers_first_card),print_cards(dealers_second_card), dealers_total))

        #if the dealers total is under 17 then hit until it is equal to or above 17

        while int(dealers_total) < 17: # work out why this isn't working
            #hit dealer
            hit(bj_deck, dealers_cards)
            check_dealers_ace(dealers_cards,dealers_total)
            dealers_total = add_values(dealers_cards)
            print("The Dealers cards are: {}. For a total value of: {}".format(print_cards(dealers_cards), dealers_total))
        #else:
         #   break
else:
    if players_total > 21:
        print("You lose!")
    elif dealers_total > 21 and players_total <=21:
        print("You win!")
    elif dealers_total < 21 and players_total < 21 and dealers_total == players_total:
        print("You draw!")
    elif players_total <= 21 and players_total > dealers_total:
        print("You win!")
    elif dealers_total <= 21 and dealers_total > players_total:
        print("You lose!")







