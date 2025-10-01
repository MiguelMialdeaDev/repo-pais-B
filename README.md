# País B - Brasil 🇧🇷

Aplicativo Android para Brasil que utiliza os módulos compartilhados de `repo-principal`.

## 🚀 Stack Tecnológico

- **Kotlin** 1.9.20
- **Jetpack Compose** - UI moderna
- **Android SDK** 34
- **Módulos compartilhados**:
  - `shared-models` - Modelos de dados
  - `shared-components` - Componentes UI
  - `shared-screens` - Telas base

## 📦 Dependências

Este projeto depende dos módulos compartilhados publicados desde `repo-principal`:

```kotlin
implementation("com.org:shared-models:1.0.0")
implementation("com.org:shared-components:1.0.0")
implementation("com.org:shared-screens:1.0.0")
```

## 🛠️ Configuração

### 1. Configurar GitHub Packages

Crie ou edite `~/.gradle/gradle.properties`:

```properties
gpr.user=seu-github-username
gpr.token=seu-github-token
```

### 2. Usar módulos desde mavenLocal (desenvolvimento)

Se está desenvolvendo localmente:

```bash
# Em repo-principal
cd ../repo-principal
./scripts/publish-local.sh

# Voltar a este projeto
cd ../repo-pais-B
./gradlew clean build
```

## 🏃 Executar

```bash
./gradlew assembleDebug
./gradlew installDebug
```

Ou do Android Studio: Run > Run 'app'

## 📱 Características

- **HomeScreen**: Tela principal com exemplos de uso de componentes compartilhados
- **ProfileScreen**: Perfil de usuário usando `UserModel`
- **SplashScreen**: Tela de início personalizada
- **Navigation**: Navegação com Jetpack Compose Navigation

## 🔗 Repositórios Relacionados

- [repo-principal](../repo-principal) - Módulos compartilhados
- [repo-pais-A](../repo-pais-A) - App Argentina 🇦🇷
- [repo-pais-C](../repo-pais-C) - App Colômbia 🇨🇴

## 📄 License

MIT License
