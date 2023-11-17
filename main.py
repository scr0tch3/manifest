from selenium import webdriver
from bs4 import BeautifulSoup
import requests

# Получение содержимого чата
url = "https://kick.com/mellstroy"
page = requests.get(url)
soup = BeautifulSoup(page.content, 'html.parser')
messages = soup.find_all(class_="chat-message-identity")

for message in messages:
    message_content = message.get_text()
    if message_content.startswith("MELL"):
        # Вставка сообщения на сайт vavada в окно промокода
        driver = webdriver.Chrome(executable_path="путь_к_вашему_драйверу/chromedriver")  # Укажите путь к chromedriver
        driver.get("https://vavadajhc.com/ru/profile/bonus/")
        promo_code_input = driver.find_element_by_id("promo_code_token")  # Замените "promo_code_token" на реальный id ввода промокода
        promo_code_input.send_keys(message_content)
        # Другие действия, если необходимо
        driver.quit()